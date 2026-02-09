package com.example.model;

public enum VisitorPurpose {
    BUSINESS("🏢 BUSINESS"),
    TOURISM("✈️ TOURISM"),
    DELIVERY("📦 DELIVERY"),
    EDUCATION("🎓 EDUCATION"),
    MEETING("🤝 MEETING"),
    OTHER("❓ OTHER");

    private final String display;

    VisitorPurpose(String display) {
        this.display = display;
    }

    public String getDisplay() { return display; }

    // From JSP value (1-6) to enum
    public static VisitorPurpose fromValue(int value) {
        return switch (value) {
            case 1 -> BUSINESS;
            case 2 -> TOURISM;
            case 3 -> DELIVERY;
            case 4 -> EDUCATION;
            case 5 -> MEETING;
            case 6 -> OTHER;
            default -> OTHER;
        };
    }
}
