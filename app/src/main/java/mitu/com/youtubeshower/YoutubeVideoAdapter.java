package mitu.com.youtubeshower;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.List;

/**
 * Created by mitu on 8/25/16.
 */
public class YoutubeVideoAdapter  extends RecyclerView.Adapter<YoutubeVideoAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private List<String> mDataset;
    private static CrazyDealListener mCrazydealListener;
    private Context mContext;
    private MediaController mediaController;

    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private VideoView videoView;

        public DataObjectHolder(View itemView) {
            super(itemView);

            videoView = (VideoView) itemView.findViewById(R.id.videoView);


            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCrazydealListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(CrazyDealListener crazyDealListener) {
        this.mCrazydealListener = crazyDealListener;
    }

    public YoutubeVideoAdapter(List<String> myDataset, Context applicationContext) {

        mDataset = myDataset;
        mContext = applicationContext;
        mediaController = new MediaController(mContext);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_layout_youtube_video, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {

        Uri uri=Uri.parse(mDataset.get(position));
        mediaController.setAnchorView(holder.videoView);
        holder.videoView.setMediaController(mediaController);
        holder.videoView.setVideoURI(uri);


        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.videoView.requestFocus();
                holder.videoView.start();
            }
        });
    }




    @Override
    public int getItemCount() {

        return mDataset.size();
    }


    public interface CrazyDealListener {
        void onItemClick(int position, View v);
    }



}

