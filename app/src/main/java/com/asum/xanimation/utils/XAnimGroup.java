package com.asum.xanimation.utils;

import android.view.View;

import java.util.ArrayList;

public class XAnimGroup {
	private ArrayList<XSingleAnim> singleAnims;

	public XAnimGroup add(XSingleAnim singleAnim) {
		if (singleAnims == null) {
			singleAnims = new ArrayList<XSingleAnim>();
		}
		singleAnims.add(singleAnim);
		return this;
	}

	public void start(View view) {
		if (singleAnims != null) {
			for (int i = 0; i < singleAnims.size(); i++) {
				singleAnims.get(i).start(view);
			}
		}
	}
}
