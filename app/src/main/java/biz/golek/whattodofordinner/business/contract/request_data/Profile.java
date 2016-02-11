package biz.golek.whattodofordinner.business.contract.request_data;

public enum Profile {
    OnlyNot,
    PreferNot,
    DoesntMatter,
    Prefer,
    Only;

    public static Profile fromInt(Integer value) {
        switch (value) {
            case 1:
                return Profile.OnlyNot;
            case 2:
                return Profile.PreferNot;
            case 3:
                return Profile.DoesntMatter;
            case 4:
                return Profile.Prefer;
            case 5:
                return Profile.Only;
            default:
                throw new RuntimeException();
        }
    }

    public static Integer toInt(Profile value)
    {
        if (value == Profile.OnlyNot)
            return 1;
        if (value == Profile.PreferNot)
            return 2;
        if (value == Profile.DoesntMatter)
            return 3;
        if (value == Profile.Prefer)
            return 4;
        if (value == Profile.Only)
            return 5;

        throw new RuntimeException();
    }

}
