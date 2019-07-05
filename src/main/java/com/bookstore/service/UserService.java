package com.bookstore.service;

import java.util.Set;

import com.bookstore.model.User;
import com.bookstore.model.UserFaturamento;
import com.bookstore.model.UserPagamento;
import com.bookstore.model.UserRemessa;
import com.bookstore.model.security.PasswordResetToken;
import com.bookstore.model.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User findById(Long id);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	void updateUserBilling(UserFaturamento userBilling, UserPagamento userPayment, User user);
	
	void updateUserShipping(UserRemessa userShipping, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);
}
