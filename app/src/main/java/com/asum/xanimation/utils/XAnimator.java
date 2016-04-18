package com.asum.xanimation.utils;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * X动画类（不支持在同一个XAnimator对象内设置两个两个一样类型的动画，要想使用两个或以上一样的动画，请实例多个XAnimator对象）<br/>
 * 方法介绍：<br/>
 * 1）alphas-设置透明度动画透明度变化值<br/>
 * 2）translationXs-设置X坐标变化的变化值<br/>
 * 3）translationYs-设置Y坐标变化的变化值<br/>
 * 4）rotateXs-设置3D旋转X轴变化的变化值<br/>
 * 5）rotateYs-设置3D旋转Y轴变化的变化值<br/>
 * 6）rotations-设置旋转角度变化的变化值<br/>
 * 7）scaleXs-设置X轴方向放大缩小的变化值<br/>
 * 8）scaleYs-设置Y轴方向放大缩小的变化值<br/>
 * 9）colors-设置颜色变化的变化值<br/>
 * 10）repeatCounts-设置动画重复次数<br/>
 * 11）repeatMode-设置动画的重复模式<br/>
 * 12）interpolators-设置速度窜改器<br/>
 * 13）delays-设置延时<br/>
 * 14）durations-设置动画持续时间<br/>
 * 15）callBack-设置回调函数 <br/>
 * 16）start-动画开始
 * 
 * @author Asum
 * 
 */
public class XAnimator {
	/**
	 * 透明度变化动画
	 */
	public static final String ANIM_ALPHA = "alpha";

	/**
	 * XY坐标共同变化动画
	 */
	public static final String ANIM_TRANSLATION_XY = "anim_translation";

	/**
	 * X坐标变化动画
	 */
	public static final String ANIM_TRANSLATION_X = "translationX";

	/**
	 * Y坐标变化动画
	 */
	public static final String ANIM_TRANSLATION_Y = "translationY";

	/**
	 * XY轴同时旋转变化动画（3D）
	 */
	public static final String ANIM_ROTATE_XY_3D = "anim_rotate_xy_3d";

	/**
	 * X轴旋转变化动画（3D）
	 */
	public static final String ANIM_ROTATE_X_3D = "rotationX";

	/**
	 * Y轴旋转变化动画（3D）
	 */
	public static final String ANIM_ROTATE_Y_3D = "rotationY";

	/**
	 * 旋转角度变化动画
	 */
	public static final String ANIM_ROTATION = "rotation";

	/**
	 * XY方向大小放大缩小动画
	 */
	public static final String ANIM_SCALE_XY = "anim_scale_xy";

	/**
	 * X方向大小放大缩放动画
	 */
	public static final String ANIM_SCALE_X = "scaleX";

	/**
	 * Y方向大小放大缩放动画
	 */
	public static final String ANIM_SCALE_Y = "scaleY";

	/**
	 * 颜色改变动画
	 */
	public static final String ANIM_COLOR = "backgroundColor";

	/**
	 * 无限重复
	 */
	public static final int INFINITE = ValueAnimator.INFINITE;

	/**
	 * 从头开始
	 */
	public static final int RESTART = ValueAnimator.RESTART;

	/**
	 * 反向开始
	 */
	public static final int REVERSE = ValueAnimator.REVERSE;

	private View view;
	private String[] animType;
	private float[] alphaValues;
	private float[] translationXValues;
	private float[] translationYValues;
	private float[] rotateXValues;
	private float[] rotateYValues;
	private float[] rotationValues;
	private float[] scaleXValues;
	private float[] scaleYValues;
	private int[] colorValues;
	private int[] delays;
	private int[] durations;
	private int[] repeatCounts;
	private int[] repeatModes;
	private Interpolator[] interpolators;
	private XAnimatorCallBack callBack;

	/**
	 * X动画类
	 * 
	 * @param view
	 *            受体控件
	 * @param animType
	 *            动画类型
	 */
	public XAnimator(View view, String... animType) {
		this.view = view;
		this.animType = animType;

		repeatCounts = new int[this.animType.length];
		repeatModes = new int[this.animType.length];
		delays = new int[this.animType.length];
		durations = new int[this.animType.length];
		interpolators = new Interpolator[this.animType.length];

		for (int i = 0; i < this.animType.length; i++) {
			repeatCounts[i] = 0;
			repeatModes[i] = ValueAnimator.RESTART;
			interpolators[i] = new LinearInterpolator();
			delays[i] = 1;
			durations[i] = 1000;
		}
	}

	/**
	 * 设置透明度动画透明度变化值
	 * 
	 * @param alphaValues
	 *            长度不能为0，且不能为空，例如：1,0.5f,0.8f,0.9f
	 * @return XAnimator 实例对象
	 */
	public XAnimator alphas(float... alphaValues) {
		this.alphaValues = alphaValues;
		return this;
	}

	/**
	 * 设置X坐标变化的变化值
	 * 
	 * @param translationXValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator translationXs(float... translationXValues) {
		this.translationXValues = translationXValues;
		return this;
	}

	/**
	 * 设置Y坐标变化的变化值
	 * 
	 * @param translationYValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator translationYs(float... translationYValues) {
		this.translationYValues = translationYValues;
		return this;
	}

	/**
	 * 设置3D旋转X轴变化的变化值
	 * 
	 * @param rotateXValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator rotateXs(float... rotateXValues) {
		this.rotateXValues = rotateXValues;
		return this;
	}

	/**
	 * 设置3D旋转Y轴变化的变化值
	 * 
	 * @param rotateYValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator rotateYs(float... rotateYValues) {
		this.rotateYValues = rotateYValues;
		return this;
	}

	/**
	 * 设置旋转角度变化的变化值
	 * 
	 * @param rotationValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator rotations(float... rotationValues) {
		this.rotationValues = rotationValues;
		return this;
	}

	/**
	 * 设置X轴方向放大缩小的变化值
	 * 
	 * @param scaleXValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator scaleXs(float... scaleXValues) {
		this.scaleXValues = scaleXValues;
		return this;
	}

	/**
	 * 设置Y轴方向放大缩小的变化值
	 * 
	 * @param scaleYValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator scaleYs(float... scaleYValues) {
		this.scaleYValues = scaleYValues;
		return this;
	}

	/**
	 * 设置颜色变化的变化值
	 * 
	 * @param colorValues
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator colors(int... colorValues) {
		this.colorValues = colorValues;
		return this;
	}

	/**
	 * 设置动画重复次数，默认1次，如果是多个不同动画重复的次数不一样，请为每个动画设置重复次数，注：无限重复为XAnimator.INFINITE
	 * 
	 * @param repeatCounts
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator repeatCounts(int... repeatCounts) {
		this.repeatCounts = repeatCounts;
		return this;
	}

	/**
	 * 设置动画的重复模式，默认是从头开始，即XAnimator.RESTART，还有可选设置：XAnimator.REVERSE，为反方向执行， 如果是多个不同动画的重复模式不同或不为默认，请为每个动画设置重复模式
	 * 
	 * @param repeatModes
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator repeatMode(int... repeatModes) {
		this.repeatModes = repeatModes;
		return this;
	}

	/**
	 * 设置速度窜改器，默认为线性变化，如果是多个不同动画拥有不一样的速度，请为每个动画设置窜改器，注：提供可选值<br/>
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
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator interpolators(Interpolator... interpolators) {
		this.interpolators = interpolators;
		return this;
	}

	/**
	 * 设置延时，如果是多个不同动画不同时间进行，请设置多个时间，默认为100毫秒
	 * 
	 * @param delays
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator delays(int... delays) {
		this.delays = delays;
		return this;
	}

	/**
	 * 设置动画持续时间，如果是多个不同动画持续不同的时间长度，请设置多个持续时间，默认为1000毫秒
	 * 
	 * @param durations
	 *            长度不能为0，且不能为空
	 * @return XAnimator 实例对象
	 */
	public XAnimator durations(int... durations) {
		this.durations = durations;
		return this;
	}

	/**
	 * 设置回调函数
	 * 
	 * @param callBack
	 * @return XAnimator 实例对象
	 */
	public XAnimator callBack(XAnimatorCallBack callBack) {
		this.callBack = callBack;
		return this;
	}

	/**
	 * 动画开始
	 */
	public void start() {
		for (int i = 0; i < animType.length; i++) {
			ValueAnimator anim1 = null, anim2 = null;

			if (animType[i].equals(ANIM_COLOR)) {
				anim1 = ObjectAnimator.ofInt(view, animType[i], colorValues);
				anim1.setEvaluator(new ArgbEvaluator());
			} else if (animType[i].equals(ANIM_TRANSLATION_XY)) {
				anim1 = ObjectAnimator.ofFloat(view, "translationX", translationXValues);
				anim1.setEvaluator(new FloatEvaluator());
				anim2 = ObjectAnimator.ofFloat(view, "translationY", translationYValues);
				anim2.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_TRANSLATION_X)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], translationXValues);
				anim1.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_TRANSLATION_Y)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], translationYValues);
				anim1.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_ROTATE_XY_3D)) {
				anim1 = ObjectAnimator.ofFloat(view, "rotationX", rotateXValues);
				anim1.setEvaluator(new FloatEvaluator());
				anim2 = ObjectAnimator.ofFloat(view, "rotationY", rotateYValues);
				anim2.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_ROTATE_X_3D)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], rotateXValues);
				anim1.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_ROTATE_Y_3D)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], rotateYValues);
			} else if (animType[i].equals(ANIM_SCALE_XY)) {
				anim1 = ObjectAnimator.ofFloat(view, "scaleX", scaleXValues);
				anim1.setEvaluator(new FloatEvaluator());
				anim2 = ObjectAnimator.ofFloat(view, "scaleY", scaleYValues);
				anim2.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_SCALE_X)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], scaleXValues);
				anim1.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_SCALE_Y)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], scaleYValues);
				anim1.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_ROTATION)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], rotationValues);
				anim1.setEvaluator(new FloatEvaluator());
			} else if (animType[i].equals(ANIM_ALPHA)) {
				anim1 = ObjectAnimator.ofFloat(view, animType[i], alphaValues);
				anim1.setEvaluator(new FloatEvaluator());
			}

			anim1.addListener(new Animator.AnimatorListener() {
				public void onAnimationStart(Animator arg0) {
					if (callBack != null) {
						callBack.start(view, arg0.toString());
					}
				}

				public void onAnimationRepeat(Animator arg0) {
					if (callBack != null) {
						callBack.repeat(view, arg0.toString());
					}
				}

				public void onAnimationEnd(Animator arg0) {
					if (callBack != null) {
						callBack.end(view, arg0.toString());
					}
				}

				public void onAnimationCancel(Animator arg0) {

				}
			});
			anim1.setDuration(durations[i]);
			anim1.setStartDelay(delays[i]);
			anim1.setRepeatCount(repeatCounts[i]);
			anim1.setRepeatMode(repeatModes[i]);
			anim1.start();

			if (anim2 != null) {
				anim2.setDuration(durations[i]);
				anim2.setStartDelay(delays[i]);
				anim2.setRepeatCount(repeatCounts[i]);
				anim2.setRepeatMode(repeatModes[i]);
				anim2.start();
			}
		}
	}

	public interface XAnimatorCallBack {
		/**
		 * 动画开始
		 * 
		 * @param view
		 *            动画对象
		 * @param animType
		 *            动画类型和数值变换
		 */
		public void start(View view, String animType);

		/**
		 * 动画结束
		 * 
		 * @param view
		 *            动画对象
		 * @param animType
		 *            动画类型和数值变换
		 */
		public void end(View view, String animType);

		/**
		 * 动画重复
		 * 
		 * @param view
		 *            动画对象
		 * @param animType
		 *            动画类型和数值变换
		 */
		public void repeat(View view, String animType);
	}
}
