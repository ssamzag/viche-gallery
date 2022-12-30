const rtf = new Intl.RelativeTimeFormat(navigator.language, { numeric: 'auto' });

const units = {
    year: 24 * 60 * 60 * 1000 * 365,
    month: (24 * 60 * 60 * 1000 * 365) / 12,
    day: 24 * 60 * 60 * 1000,
    hour: 60 * 60 * 1000,
    minute: 60 * 1000,
    second: 1000
};

export const getRelativeTime = (d1: string, d2 = new Date()) => {

    if (!d1) {
        return ""
    }
    const elapsed = new Date(d1).getTime() - d2.getTime();

    // "Math.abs" accounts for both "past" & "future" scenarios
    for (const u in units) {
        // @ts-ignore
        if (Math.abs(elapsed) > units[u] || u == 'second') {
            // @ts-ignore
            return rtf.format(Math.round(elapsed / units[u]), u as Intl.RelativeTimeFormatUnit);
        }
    }
};
