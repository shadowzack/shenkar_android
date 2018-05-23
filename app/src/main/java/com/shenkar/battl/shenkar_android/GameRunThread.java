package com.shenkar.battl.shenkar_android;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameRunThread extends Thread {

    private boolean running;
    private GameSurfaceHolder gameSurfaceHolder;
    private SurfaceHolder surfaceHolder;

    public GameRunThread(GameSurfaceHolder gameSurfaceHolder, SurfaceHolder surfaceHolder)  {
        this.gameSurfaceHolder = gameSurfaceHolder;
        this.surfaceHolder= surfaceHolder;
    }

    @Override
    public void run()  {
        long startTime = System.nanoTime();

        while(running)  {
            Canvas canvas= null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (canvas)  {
                    this.gameSurfaceHolder.update();
                    this.gameSurfaceHolder.draw(canvas);
                }
            }catch(Exception e)  {
            } finally {
                if(canvas!= null)  {
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            long now = System.nanoTime() ;
            long waitTime = (now - startTime)/1000000;
            if(waitTime < 10)  {
                waitTime= 10;
            }
            try {
                this.sleep(waitTime);
            } catch(InterruptedException e)  {

            }
            startTime = System.nanoTime();
        }
    }
    public void setRunning(boolean running)  {
        this.running= running;
    }
}