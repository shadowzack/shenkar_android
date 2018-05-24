package com.shenkar.battl.shenkar_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceHolder extends SurfaceView implements SurfaceHolder.Callback {
    private GameRunThread gameThread;
    private mainCharacter submarine_;
    public GameSurfaceHolder(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
    }
    public void update() {
        this.submarine_.update();
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        this.submarine_.draw(canvas);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.submarine);
        this.submarine_ = new mainCharacter(this, chibiBitmap1, 100, 50);
        this.gameThread = new GameRunThread(this, holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                this.gameThread.setRunning(false);
                this.gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = true;
        }
    }
}

