package com.pluralsight.dp.builder;

public class House {

    private final String foundation;
    private final String structure;
    private final String roof;
    private final String interior;

    public House(HouseBuilder houseBuilder) {
        this.foundation = houseBuilder.foundation;
        this.structure = houseBuilder.structure;
        this.roof = houseBuilder.roof;
        this.interior = houseBuilder.interior;
    }

    @Override
    public String toString() {
        return "House{" + "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", interior='" + interior + '\'' +
                '}';
    }

    public static class HouseBuilder {

        private String foundation;
        private String structure;
        private String roof;
        private String interior;

        public HouseBuilder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder structure(String structure) {
            this.structure = structure;
            return this;
        }

        public HouseBuilder roof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder interior(String interior) {
            this.interior = interior;
            return this;
        }

        public House build() {
            return new House(this);
        }

    }
}
