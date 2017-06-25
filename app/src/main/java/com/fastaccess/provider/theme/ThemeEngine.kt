package com.fastaccess.provider.theme

import android.app.ActivityManager
import android.graphics.BitmapFactory
import android.support.annotation.StyleRes
import com.danielstone.materialaboutlibrary.MaterialAboutActivity
import com.fastaccess.R
import com.fastaccess.helper.Logger
import com.fastaccess.helper.PrefGetter
import com.fastaccess.helper.ViewHelper
import com.fastaccess.ui.base.BaseActivity
import com.fastaccess.ui.modules.login.LoginActivity
import com.fastaccess.ui.modules.login.LoginChooserActivity
import com.fastaccess.ui.modules.main.donation.DonateActivity
import com.fastaccess.ui.modules.reviews.changes.ReviewChangesActivity

/**
 * Created by Kosh on 07 Jun 2017, 6:52 PM
 */

object ThemeEngine {

    fun apply(activity: BaseActivity<*, *>) {
        if (hasTheme(activity)) {
            return
        }
        val themeMode = PrefGetter.getThemeType(activity)
        val themeColor = PrefGetter.getThemeColor(activity)
        activity.setTheme(getTheme(themeMode, themeColor))
        setTaskDescription(activity)
    }

    fun applyForAbout(activity: MaterialAboutActivity) {
        val themeMode = PrefGetter.getThemeType(activity)
        if (themeMode == PrefGetter.LIGHT) {
            activity.setTheme(R.style.AppTheme_AboutActivity_Light)
        } else if (themeMode == PrefGetter.DARK) {
            activity.setTheme(R.style.AppTheme_AboutActivity_Dark)
        } else if (themeMode == PrefGetter.AMLOD) {
            activity.setTheme(R.style.AppTheme_AboutActivity_Amlod)
        } else if (themeMode == PrefGetter.MID_NIGHT_BLUE) {
            activity.setTheme(R.style.AppTheme_AboutActivity_MidNightBlue)
        } else if (themeMode == PrefGetter.BLUISH) {
            activity.setTheme(R.style.AppTheme_AboutActivity_Bluish)
        }
        activity.setTaskDescription(ActivityManager.TaskDescription(activity.getString(R.string.app_name),
                BitmapFactory.decodeResource(activity.resources, R.mipmap.ic_launcher), ViewHelper.getPrimaryColor(activity)))
    }

    fun applyDialogTheme(activity: BaseActivity<*, *>) {
        val themeMode = PrefGetter.getThemeType(activity)
        val themeColor = PrefGetter.getThemeColor(activity)
        activity.setTheme(getDialogTheme(themeMode, themeColor))
        setTaskDescription(activity)
    }


    @StyleRes fun getTheme(themeMode: Int, themeColor: Int): Int {
        Logger.e(themeMode, themeColor)
        // I wish if I could simplify this :'( too many cases for the love of god.
        if (themeMode == PrefGetter.LIGHT) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.ThemeLight_Red
                PrefGetter.PINK -> return R.style.ThemeLight_Pink
                PrefGetter.PURPLE -> return R.style.ThemeLight_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.ThemeLight_DeepPurple
                PrefGetter.INDIGO -> return R.style.ThemeLight_Indigo
                PrefGetter.BLUE -> return R.style.ThemeLight
                PrefGetter.LIGHT_BLUE -> return R.style.ThemeLight_LightBlue
                PrefGetter.CYAN -> return R.style.ThemeLight_Cyan
                PrefGetter.TEAL -> return R.style.ThemeLight_Teal
                PrefGetter.GREEN -> return R.style.ThemeLight_Green
                PrefGetter.LIGHT_GREEN -> return R.style.ThemeLight_LightGreen
                PrefGetter.LIME -> return R.style.ThemeLight_Lime
                PrefGetter.YELLOW -> return R.style.ThemeLight_Yellow
                PrefGetter.AMBER -> return R.style.ThemeLight_Amber
                PrefGetter.ORANGE -> return R.style.ThemeLight_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.ThemeLight_DeepOrange
                else -> return R.style.ThemeLight
            }
        } else if (themeMode == PrefGetter.DARK) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.ThemeDark_Red
                PrefGetter.PINK -> return R.style.ThemeDark_Pink
                PrefGetter.PURPLE -> return R.style.ThemeDark_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.ThemeDark_DeepPurple
                PrefGetter.INDIGO -> return R.style.ThemeDark_Indigo
                PrefGetter.BLUE -> return R.style.ThemeDark
                PrefGetter.LIGHT_BLUE -> return R.style.ThemeDark_LightBlue
                PrefGetter.CYAN -> return R.style.ThemeDark_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.ThemeDark_Green
                PrefGetter.LIGHT_GREEN -> return R.style.ThemeDark_LightGreen
                PrefGetter.LIME -> return R.style.ThemeDark_Lime
                PrefGetter.YELLOW -> return R.style.ThemeDark_Yellow
                PrefGetter.AMBER -> return R.style.ThemeDark_Amber
                PrefGetter.ORANGE -> return R.style.ThemeDark_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.ThemeDark_DeepOrange
                else -> return R.style.ThemeDark
            }
        } else if (themeMode == PrefGetter.AMLOD) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.ThemeAmlod_Red
                PrefGetter.PINK -> return R.style.ThemeAmlod_Pink
                PrefGetter.PURPLE -> return R.style.ThemeAmlod_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.ThemeAmlod_DeepPurple
                PrefGetter.INDIGO -> return R.style.ThemeAmlod_Indigo
                PrefGetter.BLUE -> return R.style.ThemeAmlod
                PrefGetter.LIGHT_BLUE -> return R.style.ThemeAmlod_LightBlue
                PrefGetter.CYAN -> return R.style.ThemeAmlod_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.ThemeAmlod_Green
                PrefGetter.LIGHT_GREEN -> return R.style.ThemeAmlod_LightGreen
                PrefGetter.LIME -> return R.style.ThemeAmlod_Lime
                PrefGetter.YELLOW -> return R.style.ThemeAmlod_Yellow
                PrefGetter.AMBER -> return R.style.ThemeAmlod_Amber
                PrefGetter.ORANGE -> return R.style.ThemeAmlod_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.ThemeAmlod_DeepOrange
                else -> return R.style.ThemeAmlod
            }
        } else if (themeMode == PrefGetter.MID_NIGHT_BLUE) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.ThemeMidNighBlue_Red
                PrefGetter.PINK -> return R.style.ThemeMidNighBlue_Pink
                PrefGetter.PURPLE -> return R.style.ThemeMidNighBlue_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.ThemeMidNighBlue_DeepPurple
                PrefGetter.INDIGO -> return R.style.ThemeMidNighBlue_Indigo
                PrefGetter.BLUE -> return R.style.ThemeMidNighBlue
                PrefGetter.LIGHT_BLUE -> return R.style.ThemeMidNighBlue_LightBlue
                PrefGetter.CYAN -> return R.style.ThemeMidNighBlue_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.ThemeMidNighBlue_Green
                PrefGetter.LIGHT_GREEN -> return R.style.ThemeMidNighBlue_LightGreen
                PrefGetter.LIME -> return R.style.ThemeMidNighBlue_Lime
                PrefGetter.YELLOW -> return R.style.ThemeMidNighBlue_Yellow
                PrefGetter.AMBER -> return R.style.ThemeMidNighBlue_Amber
                PrefGetter.ORANGE -> return R.style.ThemeMidNighBlue_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.ThemeMidNighBlue_DeepOrange
                else -> return R.style.ThemeMidNighBlue
            }
        } else if (themeMode == PrefGetter.BLUISH) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.ThemeBluish_Red
                PrefGetter.PINK -> return R.style.ThemeBluish_Pink
                PrefGetter.PURPLE -> return R.style.ThemeBluish_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.ThemeBluish_DeepPurple
                PrefGetter.INDIGO -> return R.style.ThemeBluish_Indigo
                PrefGetter.BLUE -> return R.style.ThemeBluish
                PrefGetter.LIGHT_BLUE -> return R.style.ThemeBluish_LightBlue
                PrefGetter.CYAN -> return R.style.ThemeBluish_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.ThemeBluish_Green
                PrefGetter.LIGHT_GREEN -> return R.style.ThemeBluish_LightGreen
                PrefGetter.LIME -> return R.style.ThemeBluish_Lime
                PrefGetter.YELLOW -> return R.style.ThemeBluish_Yellow
                PrefGetter.AMBER -> return R.style.ThemeBluish_Amber
                PrefGetter.ORANGE -> return R.style.ThemeBluish_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.ThemeBluish_DeepOrange
                else -> return R.style.ThemeBluish
            }
        }
        return R.style.ThemeLight
    }

    @StyleRes fun getDialogTheme(themeMode: Int, themeColor: Int): Int {
        if (themeMode == PrefGetter.LIGHT) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.DialogThemeLight_Red
                PrefGetter.PINK -> return R.style.DialogThemeLight_Pink
                PrefGetter.PURPLE -> return R.style.DialogThemeLight_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.DialogThemeLight_DeepPurple
                PrefGetter.INDIGO -> return R.style.DialogThemeLight_Indigo
                PrefGetter.BLUE -> return R.style.DialogThemeLight
                PrefGetter.LIGHT_BLUE -> return R.style.DialogThemeLight_LightBlue
                PrefGetter.CYAN -> return R.style.DialogThemeLight_Cyan
                PrefGetter.TEAL -> return R.style.DialogThemeLight_Teal
                PrefGetter.GREEN -> return R.style.DialogThemeLight_Green
                PrefGetter.LIGHT_GREEN -> return R.style.DialogThemeLight_LightGreen
                PrefGetter.LIME -> return R.style.DialogThemeLight_Lime
                PrefGetter.YELLOW -> return R.style.DialogThemeLight_Yellow
                PrefGetter.AMBER -> return R.style.DialogThemeLight_Amber
                PrefGetter.ORANGE -> return R.style.DialogThemeLight_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.DialogThemeLight_DeepOrange
                else -> return R.style.DialogThemeLight
            }
        } else if (themeMode == PrefGetter.DARK) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.DialogThemeDark_Red
                PrefGetter.PINK -> return R.style.DialogThemeDark_Pink
                PrefGetter.PURPLE -> return R.style.DialogThemeDark_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.DialogThemeDark_DeepPurple
                PrefGetter.INDIGO -> return R.style.DialogThemeDark_Indigo
                PrefGetter.BLUE -> return R.style.DialogThemeDark
                PrefGetter.LIGHT_BLUE -> return R.style.DialogThemeDark_LightBlue
                PrefGetter.CYAN -> return R.style.DialogThemeDark_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.DialogThemeDark_Green
                PrefGetter.LIGHT_GREEN -> return R.style.DialogThemeDark_LightGreen
                PrefGetter.LIME -> return R.style.DialogThemeDark_Lime
                PrefGetter.YELLOW -> return R.style.DialogThemeDark_Yellow
                PrefGetter.AMBER -> return R.style.DialogThemeDark_Amber
                PrefGetter.ORANGE -> return R.style.DialogThemeDark_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.DialogThemeDark_DeepOrange
                else -> return R.style.DialogThemeDark
            }
        } else if (themeMode == PrefGetter.AMLOD) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.DialogThemeAmlod_Red
                PrefGetter.PINK -> return R.style.DialogThemeAmlod_Pink
                PrefGetter.PURPLE -> return R.style.DialogThemeAmlod_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.DialogThemeAmlod_DeepPurple
                PrefGetter.INDIGO -> return R.style.DialogThemeAmlod_Indigo
                PrefGetter.BLUE -> return R.style.DialogThemeAmlod
                PrefGetter.LIGHT_BLUE -> return R.style.DialogThemeAmlod_LightBlue
                PrefGetter.CYAN -> return R.style.DialogThemeAmlod_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.DialogThemeAmlod_Green
                PrefGetter.LIGHT_GREEN -> return R.style.DialogThemeAmlod_LightGreen
                PrefGetter.LIME -> return R.style.DialogThemeAmlod_Lime
                PrefGetter.YELLOW -> return R.style.DialogThemeAmlod_Yellow
                PrefGetter.AMBER -> return R.style.DialogThemeAmlod_Amber
                PrefGetter.ORANGE -> return R.style.DialogThemeAmlod_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.DialogThemeAmlod_DeepOrange
                else -> return R.style.DialogThemeAmlod
            }
        } else if (themeMode == PrefGetter.MID_NIGHT_BLUE) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.DialogThemeLight_Red
                PrefGetter.PINK -> return R.style.DialogThemeLight_Pink
                PrefGetter.PURPLE -> return R.style.DialogThemeLight_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.DialogThemeLight_DeepPurple
                PrefGetter.INDIGO -> return R.style.DialogThemeLight_Indigo
                PrefGetter.BLUE -> return R.style.DialogThemeLight
                PrefGetter.LIGHT_BLUE -> return R.style.DialogThemeLight_LightBlue
                PrefGetter.CYAN -> return R.style.DialogThemeLight_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.DialogThemeLight_Green
                PrefGetter.LIGHT_GREEN -> return R.style.DialogThemeLight_LightGreen
                PrefGetter.LIME -> return R.style.DialogThemeLight_Lime
                PrefGetter.YELLOW -> return R.style.DialogThemeLight_Yellow
                PrefGetter.AMBER -> return R.style.DialogThemeLight_Amber
                PrefGetter.ORANGE -> return R.style.DialogThemeLight_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.DialogThemeLight_DeepOrange
                else -> return R.style.DialogThemeLight
            }
        } else if (themeMode == PrefGetter.BLUISH) {
            when (themeColor) {
                PrefGetter.RED -> return R.style.DialogThemeBluish_Red
                PrefGetter.PINK -> return R.style.DialogThemeBluish_Pink
                PrefGetter.PURPLE -> return R.style.DialogThemeBluish_Purple
                PrefGetter.DEEP_PURPLE -> return R.style.DialogThemeBluish_DeepPurple
                PrefGetter.INDIGO -> return R.style.DialogThemeBluish_Indigo
                PrefGetter.BLUE -> return R.style.DialogThemeBluish
                PrefGetter.LIGHT_BLUE -> return R.style.DialogThemeBluish_LightBlue
                PrefGetter.CYAN -> return R.style.DialogThemeBluish_Cyan
                PrefGetter.TEAL, PrefGetter.GREEN -> return R.style.DialogThemeBluish_Green
                PrefGetter.LIGHT_GREEN -> return R.style.DialogThemeBluish_LightGreen
                PrefGetter.LIME -> return R.style.DialogThemeBluish_Lime
                PrefGetter.YELLOW -> return R.style.DialogThemeBluish_Yellow
                PrefGetter.AMBER -> return R.style.DialogThemeBluish_Amber
                PrefGetter.ORANGE -> return R.style.DialogThemeBluish_Orange
                PrefGetter.DEEP_ORANGE -> return R.style.DialogThemeBluish_DeepOrange
                else -> return R.style.DialogThemeBluish
            }
        }
        return R.style.DialogThemeLight
    }

    private fun setTaskDescription(activity: BaseActivity<*, *>) {
        activity.setTaskDescription(ActivityManager.TaskDescription(activity.getString(R.string.app_name),
                BitmapFactory.decodeResource(activity.getResources(), R.mipmap.ic_launcher), ViewHelper.getPrimaryColor(activity)))
    }

    private fun hasTheme(activity: BaseActivity<*, *>) = (activity is LoginChooserActivity || activity is LoginActivity ||
            activity is DonateActivity || activity is ReviewChangesActivity)
}
