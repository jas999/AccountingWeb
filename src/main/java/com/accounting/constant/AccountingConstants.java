package com.accounting.constant;

public class AccountingConstants {
	public enum ErrorCodes {
		UserNotFound(99),
		IncorrectEmailOrPassword(100), 
		IncorrectPassword(101), 
		UserNameOrEmailAlreadyTaken(102), 
		EmailAlreadyTaken(103), 
		EmailLenghtMustBeSixCharater(104),
		NameLenghtMustBeSixCharater(105),
		PasswordLenghtMustBeSixCharater(106), 
		UserNameLenghtMustBeSixCharater(107),
		RowNotFound(108),
		UserDoestNotHavePermission(109),
		FriendAlreadyNotYourFriend(110),
		FriendAlreadyYourFriend(111),
		CantFollowYourSelf(112),
		FacebookLoginNeedAcessToekn(113),
		FacebookAcessTokenExpires(114),
		PasswordNotPresent(115),
		EmailNotPresent(116),
		FacebookIdNotPresent(117),
		FacebookTokenNotPresent(118),
		NameNotPresent(119),
		AuthTypeNotPresent(120),
		InternalServerError(121);
		int errorCode;

		private ErrorCodes(int i) {
			errorCode = i;
		}

		public int getErrorCode() {
			return errorCode;
		}
	}
}
