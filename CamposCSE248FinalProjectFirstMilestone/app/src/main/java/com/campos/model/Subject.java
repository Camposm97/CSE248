package com.campos.model;

public enum Subject {
    ANT, ART, BIO, CHE, CHI, CIN, CSE, ENG, FRE, GEO, GER, HIS, HUM, IND, ITL, JPN, LAT, MAT, MUS, PED, PHL, PHY, POL, SPN, THR;

    public static String getLabel(Subject s) {
        return s + "-" + getTitle(s);
    }

    public static String getTitle(Subject s) {
        switch (s) {
            case ANT:
                return "Anthropology";
            case ART:
                return "Visual Arts/Photography";
            case BIO:
                return "Biology";
            case CHE:
                return "Chemistry";
            case CHI:
                return "Chinese";
            case CIN:
                return "Cinema Studies";
            case CSE:
                return "Computer Science";
            case ENG:
                return "English/Journalism";
            case FRE:
                return "French";
            case GEO:
                return "Geography";
            case GER:
                return "German";
            case HIS:
                return "History";
            case HUM:
                return "Humanities";
            case IND:
                return "Interdisciplinary Studies";
            case ITL:
                return "Italian";
            case JPN:
                return "Japanese";
            case LAT:
                return "Latin";
            case MAT:
                return "Mathematics";
            case MUS:
                return "Music";
            case PED:
                return "Physical Education";
            case PHL:
                return "Philosophy";
            case PHY:
                return "Physics";
            case POL:
                return "Political Science";
            case SPN:
                return "Spanish";
            case THR:
                return "Theatre Arts";

        }
        return null;
    }
}
