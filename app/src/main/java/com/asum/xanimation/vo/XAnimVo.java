package com.asum.xanimation.vo;

import android.view.animation.Interpolator;

import com.asum.xanimation.callback.OnXAnimCallBack;

public class XAnimVo {
	private float[] alphas;
	private float[] translateXs;
	private float[] translateYs;
	private float[] rotateXs;
	private float[] rotateYs;
	private float[] rotates;
	private float[] scaleXs;
	private float[] scaleYs;
	private int[] colors;
	private int delay;
	private int duration;
	private int repeatCount;
	private int repeatModel;
	private Interpolator interpolator;
	private OnXAnimCallBack callBack;

	public float[] getAlphas() {
		return alphas;
	}

	public float[] getTranslateXs() {
		return translateXs;
	}

	public float[] getTranslateYs() {
		return translateYs;
	}

	public float[] getRotateXs() {
		return rotateXs;
	}

	public float[] getRotateYs() {
		return rotateYs;
	}

	public float[] getRotates() {
		return rotates;
	}

	public float[] getScaleXs() {
		return scaleXs;
	}

	public float[] getScaleYs() {
		return scaleYs;
	}

	public int[] getColors() {
		return colors;
	}

	public int getDelay() {
		return delay;
	}

	public int getDuration() {
		return duration;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

	public Interpolator getInterpolator() {
		return interpolator;
	}

	public OnXAnimCallBack getCallBack() {
		return callBack;
	}

	public void setAlphas(float[] alphas) {
		this.alphas = alphas;
	}

	public void setTranslateXs(float[] translateXs) {
		this.translateXs = translateXs;
	}

	public void setTranslateYs(float[] translateYs) {
		this.translateYs = translateYs;
	}

	public void setRotateXs(float[] rotateXs) {
		this.rotateXs = rotateXs;
	}

	public void setRotateYs(float[] rotateYs) {
		this.rotateYs = rotateYs;
	}

	public void setRotates(float[] rotates) {
		this.rotates = rotates;
	}

	public void setScaleXs(float[] scaleXs) {
		this.scaleXs = scaleXs;
	}

	public void setScaleYs(float[] scaleYs) {
		this.scaleYs = scaleYs;
	}

	public void setColors(int[] colors) {
		this.colors = colors;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getRepeatModel() {
		return repeatModel;
	}

	public void setRepeatModel(int repeatModel) {
		this.repeatModel = repeatModel;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}

	public void setInterpolator(Interpolator interpolator) {
		this.interpolator = interpolator;
	}

	public void setCallBack(OnXAnimCallBack callBack) {
		this.callBack = callBack;
	}
}
