package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/22.
 * 小牛牛是牛牛王国的将军,为了训练出精锐的部队,他会对新兵进行训练。
 * 部队进入了n个新兵,每个新兵有一个战斗力值和潜力值,当两个新兵进行决斗时,
 * 总是战斗力值高的获胜。获胜的新兵的战斗力值就会变成对手的潜力值 + 自己的战斗力值 - 对手的战斗力值。
 * 败者将会被淘汰。若两者战斗力值一样,则会同归于尽,双双被淘汰(除了考察的那个新兵之外，其他新兵之间不会发生战斗) 。
 * 小牛牛想知道通过互相决斗之后新兵中战斗力值+潜力值最高的一个可能达到多少,你能帮助小牛牛将军求出来吗?
 */
public class TrainSolder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Entity[] entities = new Entity[n];
		for (int i = 0; i < n; i++) {
			entities[i] = new Entity(in.nextInt(), in.nextInt());
		}
		Arrays.sort(entities, new Comparator<Entity>() {
			@Override
			public int compare(Entity o1, Entity o2) {
				return o1.biliti-o2.biliti!=0 ? o1.biliti-o2.biliti : o1.iq-o2.iq;
			}
		});
		int max = 0; //x+y的最大值
		int index = 0; // 下标
		int cha = 0; // 差值
		for (int i = 0; i < n; i++) {
			if (entities[i].biliti + entities[i].iq >= max || entities[i].biliti + entities[i].iq + cha >= max) {
				max = entities[i].biliti + entities[i].iq;
				cha = entities[i].iq - entities[i].biliti;
				index = i;
			}
		}
		long res = max;
		for (int i = index - 1; i >= 0; i--) {
			if (entities[index].biliti != entities[i].biliti && entities[i].iq > entities[i].biliti) {
				res += entities[i].iq - entities[i].biliti;
			}
		}
		System.out.println(res);
	}

	static class Entity {
		int biliti;
		int iq;

		Entity(int biliti, int iq) {
			this.biliti = biliti;
			this.iq = iq;
		}
	}
}
