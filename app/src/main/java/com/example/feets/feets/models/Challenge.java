package com.example.feets.feets.models;

public class Challenge{

        private String item;
        private String subitem;

        public Challenge(String item, String subitem) {
            this.item = item;
            this.subitem = subitem;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getSubitem() {
            return subitem;
        }

        public void setSubitem(String subitem) {
            this.subitem = subitem;
        }

}
