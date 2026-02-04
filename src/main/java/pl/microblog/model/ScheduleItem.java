package pl.microblog.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "SCHEDULE_ITEM")
public class ScheduleItem {

    @Id
    @Column(name = "schedule_item_id", nullable = false)
    private UUID scheduleItemId;

    @Column(name = "course_id", nullable = false)
    private UUID courseId;

    @Column(name = "group_code", nullable = false, length = 20)
    private String groupCode;

    @Column(name = "weekday", nullable = false)
    private Short weekday;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "room", nullable = false, length = 40)
    private String room;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    public UUID getScheduleItemId() { return scheduleItemId; }
    public void setScheduleItemId(UUID scheduleItemId) { this.scheduleItemId = scheduleItemId; }

    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }

    public String getGroupCode() { return groupCode; }
    public void setGroupCode(String groupCode) { this.groupCode = groupCode; }

    public Short getWeekday() { return weekday; }
    public void setWeekday(Short weekday) { this.weekday = weekday; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
