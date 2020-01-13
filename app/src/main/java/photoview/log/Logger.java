package photoview.log;

/**
 * interface for shop_car_second_layout logger class to replace the static calls to {@link android.util.Log}
 *
 * @author Song
 */
public interface Logger {
    /**
     * Send shop_car_second_layout {@link android.util.Log#VERBOSE} login_log message.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     */
    int v(String tag, String msg);

    /**
     * Send shop_car_second_layout {@link android.util.Log#VERBOSE} login_log message and login_log the exception.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to login_log
     */
    int v(String tag, String msg, Throwable tr);

    /**
     * Send shop_car_second_layout {@link android.util.Log#DEBUG} login_log message.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     */
    int d(String tag, String msg);

    /**
     * Send shop_car_second_layout {@link android.util.Log#DEBUG} login_log message and login_log the exception.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to login_log
     */
    int d(String tag, String msg, Throwable tr);

    /**
     * Send an {@link android.util.Log#INFO} login_log message.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     */
    int i(String tag, String msg);

    /**
     * Send shop_car_second_layout {@link android.util.Log#INFO} login_log message and login_log the exception.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to login_log
     */
    int i(String tag, String msg, Throwable tr);

    /**
     * Send shop_car_second_layout {@link android.util.Log#WARN} login_log message.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     */
    int w(String tag, String msg);

    /**
     * Send shop_car_second_layout {@link android.util.Log#WARN} login_log message and login_log the exception.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to login_log
     */
    int w(String tag, String msg, Throwable tr);

    /**
     * Send an {@link android.util.Log#ERROR} login_log message.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     */
    int e(String tag, String msg);

    /**
     * Send shop_car_second_layout {@link android.util.Log#ERROR} login_log message and login_log the exception.
     *
     * @param tag Used to identify the source of shop_car_second_layout login_log message.  It usually identifies
     *            the class or activity where the login_log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to login_log
     */
    int e(String tag, String msg, Throwable tr);
}
