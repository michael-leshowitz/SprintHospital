package Services;

import DTO.AppointmentDTO;
import Repositories.AppointmentsRepository;
import models.Appointments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AppointmentDetailsServiceImpl{

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Transactional
    public void createAppointment(AppointmentDTO appointmentDTO, Long patient_id){
        //Todo: Add some exception checking for things like "No appointments available for this doctor on this date."
//        Appointments appointment = new Appointments();
        //Todo: Appointments is a heavily connected table. This construction of a new appointment should include othere things
        //Todo: implement a getDateById in the DatesRepository and use it to get the date an set it in this appointment
//        appointment.setDates(appointmentDTO.getDate_id());
        //Todo: Finished defining departments in the sense of this database. THen implement at getDepartmentById and use it to give the date to this appointment
//        appointment.getDepartments();
        appointmentsRepository.saveAppointment(appointmentDTO.getDate_id(),
                appointmentDTO.getStaff_id(),
                patient_id);
    }
}
