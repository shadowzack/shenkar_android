package com.shenkar.battl.shenkar_android;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class mainCharacter extends submarine {
    private static final int ROW_TOP_TO_BOTTOM = 0;
    private static final int ROW_RIGHT_TO_LEFT = 0;
    private static final int ROW_LEFT_TO_RIGHT = 0;
    private static final int ROW_BOTTOM_TO_TOP = 0;
    private int rowUsing = ROW_LEFT_TO_RIGHT;
    private int colUsing;
    private Bitmap[] leftToRights;
    private Bitmap[] rightToLefts;
    private Bitmap[] topToBottoms;
    private Bitmap[] bottomToTops;
    public static final float VELOCITY = 0.1f;
    private int movingVectorX = 10;
    private int movingVectorY = 5;
    private long lastDrawNanoTime =-1;
    private GameSurfaceHolder gameSurfaceHolder;

    public mainCharacter(GameSurfaceHolder gameSurfaceHolder, Bitmap image, int x, int y) {
        super(image, 1, 1, x, y);
        this.gameSurfaceHolder = gameSurfaceHolder;
        this.topToBottoms = new Bitmap[colCount];
        this.rightToLefts = new Bitmap[colCount];
        this.leftToRights = new Bitmap[colCount];
        this.bottomToTops = new Bitmap[colCount];

        for(int col = 0; col< this.colCount; col++ ) {
            this.topToBottoms[col] = this.createSubImageAt(ROW_TOP_TO_BOTTOM, col);
            this.rightToLefts[col]  = this.createSubImageAt(ROW_RIGHT_TO_LEFT, col);
            this.leftToRights[col] = this.createSubImageAt(ROW_LEFT_TO_RIGHT, col);
            this.bottomToTops[col]  = this.createSubImageAt(ROW_BOTTOM_TO_TOP, col);
        }
    }
    public Bitmap[] getMoveBitmaps()  {
        switch (rowUsing)  {
            case ROW_BOTTOM_TO_TOP:
                return  this.bottomToTops;
            default:
                return null;
        }
    }
    public Bitmap getCurrentMoveBitmap()  {
        Bitmap[] bitmaps = this.getMoveBitmaps();
        return bitmaps[this.colUsing];
    }
    public void update()  {
        this.colUsing++;
        if(colUsing >= this.colCount)  {
            this.colUsing =0;
        }
        long now = System.nanoTime();
        if(lastDrawNanoTime==-1) {
            lastDrawNanoTime= now;
        }
        int deltaTime = (int) ((now - lastDrawNanoTime)/ 1000000 );
        float distance = VELOCITY * deltaTime;

        double movingVectorLength = Math.sqrt(movingVectorX* movingVectorX + movingVectorY*movingVectorY);
        this.x = x +  (int)(distance* movingVectorX / movingVectorLength);
        this.y = y +  (int)(distance* movingVectorY / movingVectorLength);

        if(this.x < 0 )  {
            this.x = 0;
            this.movingVectorX = - this.movingVectorX;
        } else if(this.x > this.gameSurfaceHolder.getWidth() -width)  {
            this.x= this.gameSurfaceHolder.getWidth()-width;
            this.movingVectorX = - this.movingVectorX;
        }

        if(this.y < 0 )  {
            this.y = 0;
            this.movingVectorY = - this.movingVectorY;
        } else if(this.y > this.gameSurfaceHolder.getHeight()- height)  {
            this.y= this.gameSurfaceHolder.getHeight()- height;
            this.movingVectorY = - this.movingVectorY ;
        }
        if( movingVectorX > 0 )  {
            if(movingVectorY > 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
                this.rowUsing = ROW_TOP_TO_BOTTOM;
            }else if(movingVectorY < 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
                this.rowUsing = ROW_BOTTOM_TO_TOP;
            }else  {
                this.rowUsing = ROW_LEFT_TO_RIGHT;
            }
        } else {
            if(movingVectorY > 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
                this.rowUsing = ROW_TOP_TO_BOTTOM;
            }else if(movingVectorY < 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
                this.rowUsing = ROW_BOTTOM_TO_TOP;
            }else  {
                this.rowUsing = ROW_RIGHT_TO_LEFT;
            }
        }
    }
    public void draw(Canvas canvas)  {
        Bitmap bitmap = this.getCurrentMoveBitmap();
        canvas.drawBitmap(bitmap,x, y, null);
        this.lastDrawNanoTime= System.nanoTime();
    }
    public void setMovingVector(int movingVectorX, int movingVectorY)  {
        this.movingVectorX= movingVectorX;
        this.movingVectorY = movingVectorY;
    }
}
