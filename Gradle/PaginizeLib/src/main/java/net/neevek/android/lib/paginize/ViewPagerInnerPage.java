package net.neevek.android.lib.paginize;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

/**
 * Copyright (c) 2015 neevek <i@neevek.net>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * ViewPagerInnerPage wraps a ViewPager, manages InnerPages, the main difference
 * between ViewPagerPage and ContainerInnerPage is that this class offers page
 * swiping while ContainerInnerPage does not.
 *
 * @see ViewPagerPageManager
 * @see ViewPagerPage
 */
public abstract class ViewPagerInnerPage extends InnerPage
    implements InnerPageContainer {
  private ViewPagerPageManager mViewPagerPageManager;

  public ViewPagerInnerPage(ViewWrapper innerPageContainer) {
    super(innerPageContainer);
    mViewPagerPageManager = new ViewPagerPageManager(this);
    mViewPagerPageManager.setPageScrollListener(
        new ViewPagerPageScrollListener() {
          @Override
          public void onPageScrolled(
              int position, float positionOffset, int positionOffsetPixels) {
            ViewPagerInnerPage.this.onPageScrolled(position, positionOffset,
                positionOffsetPixels);
          }

          @Override
          public void onPageSelected(int position) {
            ViewPagerInnerPage.this.onPageSelected(position);
          }

          @Override
          public void onPageScrollStateChanged(int state) {
            ViewPagerInnerPage.this.onPageScrollStateChanged(state);
          }
        });
  }

  public void setInnerPageEventNotifier(
      InnerPageEventNotifier innerPageEventNotifier) {
    mViewPagerPageManager.setInnerPageEventNotifier(innerPageEventNotifier);
  }

  public void setPageSmoothScrollEnabled(boolean enabled) {
    mViewPagerPageManager.setPageSmoothScrollEnabled(enabled);
  }

  public void setupTabLayout(TabLayout tabLayout, boolean smoothScroll) {
    mViewPagerPageManager.setupTabLayout(tabLayout, smoothScroll);
  }

  public void addPage(InnerPage page, CharSequence tabText, Drawable tabIcon) {
    mViewPagerPageManager.addPage(page, tabText, tabIcon);
  }

  public void addPage(InnerPage page, CharSequence tabText,
                      int tabIcon) {
    mViewPagerPageManager.addPage(page, tabText, tabIcon);
  }

  public void addPage(InnerPage page, CharSequence tabText) {
    mViewPagerPageManager.addPage(page, tabText);
  }

  public void addPage(InnerPage page, View tabView) {
    mViewPagerPageManager.addPage(page, tabView);
  }

  public void addPage(InnerPage page, int tabView) {
    mViewPagerPageManager.addPage(page, tabView);
  }

  public void addPage(InnerPage page) {
    mViewPagerPageManager.addPage(page);
  }

  public void setCurrentPage(int index, boolean animated) {
    mViewPagerPageManager.setCurrentPage(index, animated);
  }

  public int getCurrentPageIndex() {
    return mViewPagerPageManager.getCurrentPageIndex();
  }

  public int getPageCount() {
    return mViewPagerPageManager.getPageCount();
  }

  public void setHorizontalFadingEdgeEnabled(boolean enabled) {
    mViewPagerPageManager.setHorizontalFadingEdgeEnabled(enabled);
  }

  public void setFadingEdgeLength(int length) {
    mViewPagerPageManager.setFadingEdgeLength(length);
  }

  protected void onPageScrolled(int position, float positionOffset,
                                int positionOffsetPixels) {  }
  protected void onPageSelected(int position) { }
  protected void onPageScrollStateChanged(int state) { }

  public int indexOf(InnerPage innerPage) {
    return mViewPagerPageManager.indexOf(innerPage);
  }

  @Override
  public ViewGroup getContainerView() {
    return mViewPagerPageManager.getContainerView();
  }

  @Override
  public void onShow() {
    mViewPagerPageManager.onShow();
  }

  @Override
  public void onShown() {
    mViewPagerPageManager.onShown();
  }

  @Override
  public void onResume() {
    mViewPagerPageManager.onResume();
  }

  @Override
  public void onPause() {
    mViewPagerPageManager.onPause();
  }

  @Override
  public boolean onBackPressed() {
    return mViewPagerPageManager.onBackPressed();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    mViewPagerPageManager.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    return mViewPagerPageManager.onKeyDown(keyCode, event);
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    return mViewPagerPageManager.onKeyUp(keyCode, event);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return mViewPagerPageManager.onTouchEvent(event);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    mViewPagerPageManager.onConfigurationChanged(newConfig);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    mViewPagerPageManager.onSaveInstanceState(outState);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState) {
    mViewPagerPageManager.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  public void onHide() {
    mViewPagerPageManager.onHide();
  }

  @Override
  public void onHidden() {
    mViewPagerPageManager.onHidden();
  }

  @Override
  public void onCover() {
    mViewPagerPageManager.onCover();
  }

  @Override
  public void onCovered() {
    mViewPagerPageManager.onCovered();
  }

  @Override
  public void onUncover(Object arg) {
    mViewPagerPageManager.onUncover(arg);
  }

  @Override
  public void onUncovered(Object arg) {
    mViewPagerPageManager.onUncovered(arg);
  }

  @Override
  public void onDestroy() {
    mViewPagerPageManager.onDestroy();
  }
}
