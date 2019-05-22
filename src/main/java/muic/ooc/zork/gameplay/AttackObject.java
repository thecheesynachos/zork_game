package muic.ooc.zork.gameplay;

public class AttackObject {

	private int damage;
	private int stunTurn;

	public int getDamage() {
		return damage;
	}

	public int getStunTurn() {
		return stunTurn;
	}

	public static class Builder {

		private int damage = 0;
		private int stunTurn = 0;

		public Builder damage(int damage){
			this.damage = damage;
			return this;
		}

		public Builder stunTurn(int stunTurn){
			this.stunTurn = stunTurn;
			return this;
		}

		public AttackObject build(){
			AttackObject attackObject = new AttackObject();
			attackObject.damage = this.damage;
			attackObject.stunTurn = this.stunTurn;
			return attackObject;
		}

	}

}
