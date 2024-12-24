public enum WorkerLevel {
    JUNIOR,
    MID_LEVEL,
    SENIOR;

    @Override
    public String toString() {
        return switch (this) {
            case JUNIOR -> "Junior";
            case MID_LEVEL -> "Mid level.";
            case SENIOR -> "Senior.";
        };
    }
}
