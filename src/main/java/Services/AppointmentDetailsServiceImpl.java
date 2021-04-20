package Services;

import DTO.AppointmentDTO;
import Repositories.AppointmentsRepository;
import models.Appointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AppointmentDetailsServiceImpl{

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Transactional
    public void createAppointment(AppointmentDTO appointmentDTO, Long patient_id) throws AppointmentContendedError{
        //Todo: Add some exception checking for things like "No appointments available for this doctor on this date."
//        Appointments appointment = new Appointments();
        //Todo: Appointments is a heavily connected table. This construction of a new appointment should include othere things
        //Todo: implement a getDateById in the DatesRepository and use it to get the date an set it in this appointment
//        appointment.setDates(appointmentDTO.getDate_id());
        //Todo: Finished defining departments in the sense of this database. THen implement at getDepartmentById and use it to give the date to this appointment
//        appointment.getDepartments();

        if(appointmentBooked(appointmentDTO.getStaff_id(), appointmentDTO.getDate_id(), appointmentDTO.getTime())){
            throw new AppointmentContendedError("There is not availabilty for this time slot.");
        }
        appointmentsRepository.saveAppointment(appointmentDTO.getDate_id(),
                appointmentDTO.getStaff_id(),
                patient_id,
                appointmentDTO.getTime());
    }

    public List<Appointments> findAppointmentSchedule(Long user_id){
        List<Appointments> upcomingAppointments = appointmentsRepository.findUpcomingAppointmentByPatientId(user_id);
        return upcomingAppointments;
    }

    public List<Appointments> findAdminAppointmentSchedule(Long user_id){
        List<Appointments> upcomingAppointments = appointmentsRepository.findAdminAppointmentSchedule(user_id);
        return  upcomingAppointments;
    }

    public void deleteByAppId(Integer appId) {
        //Todo: Add error checking and documentation to this method
        appointmentsRepository.deleteByAppId(appId);
    }

    private boolean appointmentBooked(Integer user_id, Integer date_id, String time){
        return !(appointmentsRepository.findAppointmentByStaffDateTime(user_id, date_id, time).isEmpty());
    }

    public class AppointmentContendedError extends Exception{
        public AppointmentContendedError(String message) {
            super(message);
        }
    }
}
