package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/8/4.
 */
public class DenseLine {
	public static double[] getLine(Point[] p, int n) {
		// write code here
		double count = 0;
		HashMap<line, Integer> map = new HashMap<>();
		int max = 0;
		double slope = Double.POSITIVE_INFINITY, intercept = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double k = (double) ((p[i].y - p[j].y) / (p[i].x - p[j].x));
				double x = (double) (p[i].y - k * p[i].x);
				line line = new line(k, x);
				if (map.containsKey(line)) {
					map.put(line, map.get(line) + 1);
					if (map.get(line) + 1 > max) {
						max = map.get(line) + 1;
						slope = line.k;
						intercept = line.x;
					}
				} else {
					map.put(line, 1);
				}
			}
		}
		return new double[]{slope, intercept};
	}


	public static class line {
		double k;
		double x;
		double epsilon = 0.0001;

		public line(double k, double x) {
			this.k = k;
			this.x = x;
		}

		private boolean isEquls(double a, double b) {
			return Math.abs(a - b) < epsilon;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			line line = (line) o;

			if (!isEquls(k, line.k)) return false;
			return isEquls(x, line.x);
		}

		@Override
		public int hashCode() {
			String str = String.valueOf(k) + String.valueOf(x);
			return str.hashCode();
		}
	}


	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point() {
			this.x = 0;
			this.y = 0;
		}
	}
}
