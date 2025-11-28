public enum Players {
    X,
    O,
    NULL {
        @Override
        public String toString() {
            return " ";
        };
    };
};