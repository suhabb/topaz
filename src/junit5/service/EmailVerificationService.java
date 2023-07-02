package junit5.service;


import junit5.model.User;

public interface EmailVerificationService {
    void scheduleEmailConfirmation(User user);
}
