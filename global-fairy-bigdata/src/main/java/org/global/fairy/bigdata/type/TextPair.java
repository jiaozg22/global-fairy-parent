package org.global.fairy.bigdata.type;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableUtils;
import org.apache.hadoop.io.IntWritable.Comparator;

public class TextPair implements WritableComparable<TextPair> {

	//不建议使用,建议使用java原生数据类型
	private Text first;// String
	private Text second;// IntWritable

	public TextPair() {

	}

	public TextPair(Text first, Text second) {
		this.set(first, second);
	}

	public void set(Text first, Text second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		first.write(out);
		second.write(out);

	}

	@Override
	public void readFields(DataInput in) throws IOException {
		first.readFields(in);
		second.readFields(in);

	}

	@Override
	public int compareTo(TextPair o) {
		// TODO Auto-generated method stub
		int cmp = this.first.compareTo(o.getFirst());
		if (0 != cmp) {
			return cmp;
		}

		return this.second.compareTo(o.getSecond());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextPair other = (TextPair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextPair [first=" + first + ", second=" + second + "]";
	}

	public Text getFirst() {
		return first;
	}

	// public void setFirst(Text first) {
	// this.first = first;
	// }

	public Text getSecond() {
		return second;
	}

	// public void setSecond(Text second) {
	// this.second = second;
	// }

	public static class Comparator extends WritableComparator {

		public Comparator(){
			super(TextPair.class);
		}

		public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
			int n1 = WritableUtils.decodeVIntSize(b1[s1]);
			int n2 = WritableUtils.decodeVIntSize(b2[s2]);

			int cmp = compareBytes(b1, s1 + n1, l1 - n1, b2, s2 + n2, l2 - n2);

			if (0 != cmp) {
				return cmp;
			}

			int thisValue = readInt(b1, l1 - s1 - n1);
			int thatValue = readInt(b2, l2 - s2 - n2);
			return (thisValue < thatValue ? -1 : (thisValue == thatValue ? 0
					: 1));

		}

		static { // register this comparator
			WritableComparator.define(TextPair.class, new Comparator());
		}
	}

}
