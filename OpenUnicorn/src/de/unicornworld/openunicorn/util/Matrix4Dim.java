package de.unicornworld.openunicorn.util;

import java.util.Stack;

public class Matrix4Dim {

	private Stack<Integer> x, y, i, w;

	public Matrix4Dim(Stack<Integer> x, Stack<Integer> y, Stack<Integer> i, Stack<Integer> w) {
		this.x = x;
		this.y = y;
		this.i = i;
		this.w = w;
	}

	public void pushXYIW(int x, int y, int i, int w) {

		this.x.push(x);
		this.y.push(y);
		this.i.push(i);
		this.w.push(w);

	}

	public void pushX(int value) {

		this.x.push(value);

	}

	public void pushY(int value) {

		this.y.push(value);

	}

	public void pushI(int value) {

		this.i.push(value);

	}

	public void pushW(int value) {

		this.w.push(value);

	}

	public Stack<Integer> getX() {
		return x;
	}

	public Stack<Integer> getY() {
		return y;
	}

	public Stack<Integer> getI() {
		return i;
	}

	public Stack<Integer> getW() {
		return w;
	}

}
