package com.link.hi.library.log;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.link.hi.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingyx
 * @description: 可视化日志打印，将log显示在界面上
 * @date: 2023/4/7
 */
public class HiViewPrinter implements HiLogPrinter {

    private RecyclerView recyclerView;
    private LogAdapter adapter;

    private HiViewPrinterProvider viewProvider;

    public HiViewPrinter(Activity activity) {
        FrameLayout rootView = activity.findViewById(android.R.id.content);
        recyclerView = new RecyclerView(activity);
        adapter = new LogAdapter(LayoutInflater.from(recyclerView.getContext()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        viewProvider = new HiViewPrinterProvider(rootView, recyclerView);
    }

    /**
     * 获取 ViewProvider
     * <p>
     * 可以通过 Provider 控制视图显示隐藏
     *
     * @return HiViewPrinterProvider
     */
    public HiViewPrinterProvider getViewProvider() {
        return viewProvider;
    }

    @Override
    public void print(@NonNull HiLogConfig config, int level, String tag, @NonNull String printString) {
        // 添加 log 到 recyclerView
        HiLogMo mo = new HiLogMo(System.currentTimeMillis(), level, tag, printString);
        adapter.addItem(mo);
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
    }

    private static class LogAdapter extends RecyclerView.Adapter<LogAdapter.LogViewHolder> {

        private LayoutInflater inflater;

        private List<HiLogMo> logs = new ArrayList<>();

        void addItem(HiLogMo logItem) {
            logs.add(logItem);
            notifyItemInserted(logs.size() - 1);
        }


        public LogAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        @NonNull
        @Override
        public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.hilog_item, parent, false);
            return new LogViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull LogViewHolder holder, int position) {
            HiLogMo logItem = logs.get(position);
            int color = getHighlightColor(logItem.level);
            holder.tagView.setTextColor(color);
            holder.messageView.setTextColor(color);
            holder.tagView.setText(logItem.tag);
            holder.messageView.setText(logItem.log);
        }

        /**
         * 根据日志级别获取颜色
         *
         * @param level 日志级别
         * @return 颜色
         */
        private int getHighlightColor(int level) {
            int highlight;
            switch (level) {
                case HiLogType.V:
                    highlight = 0xffbbbbbb;
                    break;
                case HiLogType.D:
                    highlight = 0xffffffff;
                    break;
                case HiLogType.I:
                    highlight = 0xff6a8759;
                    break;
                case HiLogType.W:
                    highlight = 0xffbbb529;
                    break;
                case HiLogType.E:
                    highlight = 0xffff6b68;
                    break;
                default:
                    highlight = 0xffffff00;
            }
            return highlight;
        }

        @Override
        public int getItemCount() {
            return logs.size();
        }

        private static class LogViewHolder extends RecyclerView.ViewHolder {

            TextView tagView;
            TextView messageView;

            public LogViewHolder(@NonNull View itemView) {
                super(itemView);
                tagView = itemView.findViewById(R.id.tv_tag);
                messageView = itemView.findViewById(R.id.tv_message);
            }
        }
    }
}
