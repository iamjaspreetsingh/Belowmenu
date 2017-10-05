package com.jskgmail.belowmenu;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;

/**
 * Created by JASPREET SINGH on 05-10-2017.
 */

class ListViewAdapter extends BaseAdapter {
    Activity context;
    ArrayList<String> title;
    ArrayList<String> description;
    ArrayList<String> per;
    ArrayList<String> perincdec;
    ArrayList<String> ch;

    public ListViewAdapter(MainActivity context, ArrayList<String> title, ArrayList<String> description,ArrayList<String> per,ArrayList<String> perincdec,ArrayList<String> ch)
    {
        super();
        this.context=context;
        this.title=title;
        this.description=description;
        this.per=per;
        this.perincdec=perincdec;
        this.ch=ch;
    }


    @Override
    public int getCount() {

        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtviewtitle;
        TextView txtviewdesc;
        TextView txtper;
        TextView txtperincde;

        ImageView img;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater inflater=context.getLayoutInflater();
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.friend_item,null);
            holder=new ViewHolder();
            holder.txtviewtitle=(TextView)convertView.findViewById(R.id.friendName);



            holder.txtviewdesc=(TextView)convertView.findViewById(R.id.textView14);
            holder.txtper=(TextView)convertView.findViewById(R.id.textView12);
            holder.txtperincde=(TextView)convertView.findViewById(R.id.textView13) ;
holder.img=(ImageView)convertView.findViewById(R.id.imageView);


        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.txtviewdesc.setText(description.get(position));

        holder.txtviewtitle.setText(title.get(position));
      if(Integer.parseInt(description.get(position))%2==0)
          holder.txtviewtitle.setTextColor(Color.GREEN);
        else
          holder.txtviewtitle.setTextColor(Color.RED);
        holder.txtper.setText(per.get(position));
        holder.txtperincde.setText(perincdec.get(position));
        TextDrawable drawable = TextDrawable.builder().beginConfig().withBorder(4).textColor(Color.BLACK).useFont(Typeface.DEFAULT).bold().toUpperCase().endConfig().buildRound(description.get(position),Color.rgb(200,2,200));
        holder.img.setImageDrawable(drawable);
        notifyDataSetChanged();
        return convertView;

    }


}
