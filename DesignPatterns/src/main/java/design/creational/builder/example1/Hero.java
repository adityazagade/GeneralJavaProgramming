package design.creational.builder.example1;

public class Hero {
    private Armour armour;
    private HairColor hairColor;
    private HairType hairType;
    private String name;
    private Profession profession;
    private Weapon weapon;

    public Armour getArmour() {
        return armour;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public HairType getHairType() {
        return hairType;
    }

    public String getName() {
        return name;
    }

    public Profession getProfession() {
        return profession;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Hero(Builder builder) {
        this.profession = builder.profession;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.weapon = builder.weapon;
        this.armour = builder.armour;
    }

    public static class Builder {
        private Armour armour;
        private HairColor hairColor;
        private HairType hairType;
        private String name;
        private Profession profession;
        private Weapon weapon;

        public Builder(String name, Profession profession) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession and name can not be null");
            }
            this.name = name;
            this.profession = profession;
        }

        public Hero build() {
            return new Hero(this);
        }

        public Builder withArmor(Armour armor) {
            this.armour = armor;
            return this;
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withHairType(HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }
    }
}
