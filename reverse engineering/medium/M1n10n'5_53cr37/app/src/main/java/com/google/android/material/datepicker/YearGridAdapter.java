package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView view) {
            super(view);
            this.textView = view;
        }
    }

    YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.materialCalendar = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        TextView yearTextView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false);
        return new ViewHolder(yearTextView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        int year = getYearForPosition(position);
        viewHolder.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(year)));
        viewHolder.textView.setContentDescription(DateStrings.getYearContentDescription(viewHolder.textView.getContext(), year));
        CalendarStyle styles = this.materialCalendar.getCalendarStyle();
        Calendar calendar = UtcDates.getTodayCalendar();
        CalendarItemStyle style = calendar.get(1) == year ? styles.todayYear : styles.year;
        for (Long day : this.materialCalendar.getDateSelector().getSelectedDays()) {
            calendar.setTimeInMillis(day.longValue());
            if (calendar.get(1) == year) {
                style = styles.selectedYear;
            }
        }
        style.styleItem(viewHolder.textView);
        viewHolder.textView.setOnClickListener(createYearClickListener(year));
    }

    /* renamed from: com.google.android.material.datepicker.YearGridAdapter$1 */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ int val$year;

        AnonymousClass1(int i) {
            i = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Month current = Month.create(i, YearGridAdapter.this.materialCalendar.getCurrentMonth().month);
            CalendarConstraints calendarConstraints = YearGridAdapter.this.materialCalendar.getCalendarConstraints();
            Month moveTo = calendarConstraints.clamp(current);
            YearGridAdapter.this.materialCalendar.setCurrentMonth(moveTo);
            YearGridAdapter.this.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    private View.OnClickListener createYearClickListener(int year) {
        return new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            final /* synthetic */ int val$year;

            AnonymousClass1(int year2) {
                i = year2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Month current = Month.create(i, YearGridAdapter.this.materialCalendar.getCurrentMonth().month);
                CalendarConstraints calendarConstraints = YearGridAdapter.this.materialCalendar.getCalendarConstraints();
                Month moveTo = calendarConstraints.clamp(current);
                YearGridAdapter.this.materialCalendar.setCurrentMonth(moveTo);
                YearGridAdapter.this.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    int getPositionForYear(int year) {
        return year - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    int getYearForPosition(int position) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + position;
    }
}
