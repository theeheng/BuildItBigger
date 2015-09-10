// Generated code from Butter Knife. Do not modify!
package com.udacity.gradle.builditbigger;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivityFragment$$ViewInjector {
  public static void inject(Finder finder, final com.udacity.gradle.builditbigger.MainActivityFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492946, "field 'tellJokeButton' and method 'onTellJokeButtonClick'");
    target.tellJokeButton = (android.widget.Button) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onTellJokeButtonClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492948, "field 'progressBarHolder'");
    target.progressBarHolder = (android.widget.FrameLayout) view;
  }

  public static void reset(com.udacity.gradle.builditbigger.MainActivityFragment target) {
    target.tellJokeButton = null;
    target.progressBarHolder = null;
  }
}
