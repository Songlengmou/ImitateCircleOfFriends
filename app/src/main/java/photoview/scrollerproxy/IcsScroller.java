package photoview.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;

/**
 * @author Song
 */
@TargetApi(14)
public class IcsScroller extends GingerScroller {

    public IcsScroller(Context context) {
        super(context);
    }

    @Override
    public boolean computeScrollOffset() {
        return mScroller.computeScrollOffset();
    }
}
