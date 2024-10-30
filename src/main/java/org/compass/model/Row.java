package org.compass.model;

public class Row {

    private final Long id;
    private final String name;
    private final String lastname;
    private final String email;
    private final String postalZip;
    private final String addressZip;

    public Row(Long id, String name, String lastname, String email, String postalZip, String addressZip) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.postalZip = postalZip;
        this.addressZip = addressZip;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPostalZip() {
        return this.postalZip;
    }

    public String getAddressZip() {
        return this.addressZip;
    }

    public static class RowBuilder {
        private Long id;
        private String name;
        private String lastName;
        private String email;
        private String postalZip;
        private String addressZip;
        public RowBuilder(){}
        public RowBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RowBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RowBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public RowBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RowBuilder postalZip(String postalZip) {
            this.postalZip = postalZip;
            return this;
        }

        public RowBuilder addressZip(String addressZip) {
            this.addressZip = addressZip;
            return this;
        }

        public Row build() {
            return new Row(this.id, this.name, this.lastName, this.email, this.postalZip, this.addressZip);
        }
    }
}
