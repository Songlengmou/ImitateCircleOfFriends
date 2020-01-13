package photoview.gestures;

import android.view.MotionEvent;

/**
 * @author Song
 */
public interface GestureDetector {
    boolean onTouchEvent(MotionEvent ev);

    boolean isScaling();

    void setOnGestureListener(OnGestureListener listener);
}
