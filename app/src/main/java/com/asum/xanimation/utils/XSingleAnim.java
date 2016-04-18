package com.asum.xanimation.utils;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;

import com.asum.xanimation.callback.OnXAnimCallBack;
import com.asum.xanimation.vo.XAnimVo;

public class XSingleAnim {
	private XAnimVo animVo;

	public XSingleAnim() {
		animVo = new XAnimVo();
	}

	public XSingleAnim alpha(double... alphas) {
		animVo.setAlphas(doubleListToFloatList(alphas));
		return this;
	}

	public XSingleAnim translateX(double... translateXs) {
		animVo.setTranslateXs(doubleListToFloatList(translateXs));
		return this;
	}

	public XSingleAnim translateY(double... translateYs) {
		animVo.setTranslateYs(doubleListToFloatList(translateYs));
		return this;
	}

	public XSingleAnim rotateX(double... rotateXs) {
		animVo.setRotateXs(doubleListToFloatList(rotateXs));
		return this;
	}

	public XSingleAnim rotateY(double... rotateYs) {
		animVo.setRotateYs(doubleListToFloatList(rotateYs));
		return this;
	}

	public XSingleAnim rotate(double... rotates) {
		animVo.setRotates(doubleListToFloatList(rotates));
		return this;
	}

	public XSingleAnim scaleX(double... scaleXs) {
		animVo.setScaleXs(doubleListToFloatList(scaleXs));
		return this;
	}

	public XSingleAnim scaleY(double... scaleYs) {
		animVo.setScaleYs(doubleListToFloatList(scaleYs));
		return this;
	}

	public XSingleAnim color(int... colors) {
		animVo.setColors(colors);
		return this;
	}

	public XSingleAnim delay(int delay) {
		animVo.setDelay(delay);
		return this;
	}

	public XSingleAnim duration(int duration) {
		animVo.setDuration(duration);
		return this;
	}

	public XSingleAnim count(int count) {
		animVo.setRepeatCount(count);
		return this;
	}

	/**
	 * 重复模式
	 * 
	 * @param valueAnimator
	 *            ValueAnimator.RESTART(从头开始) or ValueAnimator.INFINITE(无限重复) or ValueAnimator.REVERSE(反向开始)
	 * @return
	 */
	public XSingleAnim model(int model) {
		animVo.setRepeatModel(model);
		return this;
	}

	/**
	 * 设置速度窜改器，默认为线性变化，注：提供可选值<br/>
	 * 1）AccelerateDecelerateInterpolator – 先加速后减速<br/>
	 * 2）AccelerateInterpolator – 加速<br/>
	 * 3）AnticipateInterpolator – 先往后再往前<br/>
	 * 4）AnticipateOvershootInterpolator – 先往后再超过再回来<br/>
	 * 5）BounceInterpolator – 反弹<br/>
	 * 6）CycleInterpolator – 周期性重复<br/>
	 * 7）DecelerateInterpolator – 减速<br/>
	 * 8）LinearInterpolator – 定速<br/>
	 * 9）OvershootInterpolator – 超过再回来<br/>
	 * 
	 * @param interpolators
	 *            不能为空
	 * @return
	 */
	public XSingleAnim interpolators(Interpolator interpolator) {
		animVo.setInterpolator(interpolator);
		return this;
	}

	public XSingleAnim callBack(OnXAnimCallBack callBack) {
		animVo.setCallBack(callBack);
		return this;
	}

	public void start(View view) {
		ValueAnimator valueAnimator = getAnimator(view);
		valueAnimator.addListener(new Animator.AnimatorListener() {
			public void onAnimationStart(Animator arg0) {
				if (animVo.getCallBack() != null) {
					animVo.getCallBack().start();
				}
			}

			public void onAnimationRepeat(Animator arg0) {
				if (animVo.getCallBack() != null) {
					animVo.getCallBack().repeat();
				}
			}

			public void onAnimationEnd(Animator arg0) {
				if (animVo.getCallBack() != null) {
					animVo.getCallBack().end();
				}
			}

			public void onAnimationCancel(Animator arg0) {
			}
		});
		valueAnimator.setDuration(animVo.getDuration());
		valueAnimator.setStartDelay(animVo.getDelay());
		valueAnimator.setRepeatCount(animVo.getRepeatCount());
		valueAnimator.setRepeatMode(animVo.getRepeatModel());
		valueAnimator.setInterpolator(animVo.getInterpolator());
		valueAnimator.start();
	}

	private ValueAnimator getAnimator(View view) {
		ValueAnimator valueAnimator = null;

		if (animVo.getColors() != null) {// 颜色
			valueAnimator = ObjectAnimator.ofInt(view, "backgroundColor", animVo.getColors());
			valueAnimator.setEvaluator(new IntEvaluator());
		} else if (animVo.getTranslateXs() != null) {// X轴偏移
			valueAnimator = ObjectAnimator.ofFloat(view, "translationX", animVo.getTranslateXs());
			valueAnimator.setEvaluator(new FloatEvaluator());
		} else if (animVo.getTranslateYs() != null) {// Y轴偏移
			valueAnimator = ObjectAnimator.ofFloat(view, "translationY", animVo.getTranslateYs());
			valueAnimator.setEvaluator(new FloatEvaluator());
		} else if (animVo.getRotateXs() != null) {// X轴旋转
			valueAnimator = ObjectAnimator.ofFloat(view, "rotationX", animVo.getRotateXs());
			valueAnimator.setEvaluator(new FloatEvaluator());
		} else if (animVo.getRotateYs() != null) {// Y轴旋转
			valueAnimator = ObjectAnimator.ofFloat(view, "rotationY", animVo.getRotateYs());
		} else if (animVo.getScaleXs() != null) {// X轴方向缩小放大
			valueAnimator = ObjectAnimator.ofFloat(view, "scaleX", animVo.getScaleXs());
			valueAnimator.setEvaluator(new FloatEvaluator());
		} else if (animVo.getScaleYs() != null) {// Y轴方向缩小放大
			valueAnimator = ObjectAnimator.ofFloat(view, "scaleY", animVo.getScaleYs());
			valueAnimator.setEvaluator(new FloatEvaluator());
		} else if (animVo.getRotates() != null) {// 角度旋转
			valueAnimator = ObjectAnimator.ofFloat(view, "rotation", animVo.getRotates());
			valueAnimator.setEvaluator(new FloatEvaluator());
		} else if (animVo.getAlphas() != null) {// 透明度变化
			valueAnimator = ObjectAnimator.ofFloat(view, "alpha", animVo.getAlphas());
			valueAnimator.setEvaluator(new FloatEvaluator());
		}

		return valueAnimator;
	}

	private float[] doubleListToFloatList(double[] list) {
		float[] values = new float[list.length];
		for (int i = 0; i < list.length; i++) {
			values[i] = (float) list[i];
		}
		return values;
	}
}
