package config;

public class Settings
{
	public static final String clientName = ConfigReader.getPropertiesFromConfigFile("Global","clientName");
	public static final String application_Url = ConfigReader.getPropertiesFromConfigFile("Global","QAStage_Url");
	public static final String cxSupport_Url = ConfigReader.getPropertiesFromConfigFile("Global","cxSupport_Url");
	public static final String payment_Url = ConfigReader.getPropertiesFromConfigFile("Global","impark_payment_Url");
	public static final String userId = ConfigReader.getPropertiesFromConfigFile("Global","userId");
	public static final String password = ConfigReader.getPropertiesFromConfigFile("Global","password");
	public static final String cxSupportUserId = ConfigReader.getPropertiesFromConfigFile("Global","cxSupportUserId");
	public static final String cxSupportPassword = ConfigReader.getPropertiesFromConfigFile("Global","cxSupportPassword");
	public static final String paymentAppUserId = ConfigReader.getPropertiesFromConfigFile("Global","imparkPaymentUserId");
	public static final String paymentAppPassword = ConfigReader.getPropertiesFromConfigFile("Global","imparkPaymentPassword");
	public static final String browserName = ConfigReader.getPropertiesFromConfigFile("Global","browser");
	public static final String runMode = ConfigReader.getPropertiesFromConfigFile("Global","headlessMode");
	
	public static final String officerName = ConfigReader.getPropertiesFromConfigFile("Global","officerName");
	public static final String stateName = ConfigReader.getPropertiesFromConfigFile("Global","stateName");
	public static final String editStateName = ConfigReader.getPropertiesFromConfigFile("Global","editStateName");
	public static final String make = ConfigReader.getPropertiesFromConfigFile("Global","make");
	public static final String editMake = ConfigReader.getPropertiesFromConfigFile("Global","editMake");
	public static final String model = ConfigReader.getPropertiesFromConfigFile("Global","model");
	public static final String editModel = ConfigReader.getPropertiesFromConfigFile("Global","editModel");
	public static final String color = ConfigReader.getPropertiesFromConfigFile("Global","color");
	public static final String editColor = ConfigReader.getPropertiesFromConfigFile("Global","editColor");
	public static final String isLot = ConfigReader.getPropertiesFromConfigFile("Global","isLot");
	public static final String lot = ConfigReader.getPropertiesFromConfigFile("Global","lot");
	public static final String isPaidAfter = ConfigReader.getPropertiesFromConfigFile("Global","isPaidAfter");
	public static final String block = ConfigReader.getPropertiesFromConfigFile("Global","block");
	public static final String editBlock = ConfigReader.getPropertiesFromConfigFile("Global","editBlock");
	public static final String street = ConfigReader.getPropertiesFromConfigFile("Global","street");
	public static final String editStreet= ConfigReader.getPropertiesFromConfigFile("Global","editStreet");
	public static final String remark = ConfigReader.getPropertiesFromConfigFile("Global","remark");
	public static final String editRemark = ConfigReader.getPropertiesFromConfigFile("Global","editRemark");
	public static final String chargeBackFee = ConfigReader.getPropertiesFromConfigFile("Global","chargeBackFee");
	public static final String NSFFee = ConfigReader.getPropertiesFromConfigFile("Global","chargeBackFee");
	public static final String partialPayAmount = ConfigReader.getPropertiesFromConfigFile("Global","partialPayAmount");
	public static final String allowPartialPay = ConfigReader.getPropertiesFromConfigFile("Global","allowPartialPay");
	public static final String plateAnalysisMenu = ConfigReader.getPropertiesFromConfigFile("Global","plateAnalysisMenu");
	public static final String ticketCountSummaryReportMenu = ConfigReader.getPropertiesFromConfigFile("Global","ticketCountSummaryReportMenu");
	public static final String ticketListReportMenu = ConfigReader.getPropertiesFromConfigFile("Global","ticketListReportMenu");
	public static final String canRemark = ConfigReader.getPropertiesFromConfigFile("Global","canRemark");
	public static final String canSelectBody = ConfigReader.getPropertiesFromConfigFile("Global","body");
	public static final String canSelectModel = ConfigReader.getPropertiesFromConfigFile("Global","canSelectmodel");
	public static final String isAppealFromPaymentPortal = ConfigReader.getPropertiesFromConfigFile("Global","appealFromPaymentPortal");
	public static final String isAppealMultiplePaymentPortal = ConfigReader.getPropertiesFromConfigFile("Global","appealMultipleCitationPaymentPortal");
	public static final String stateOfAppealPaymentPortal = ConfigReader.getPropertiesFromConfigFile("Global","stateOfAppealPaymentPortal");
	public static final String reasonOfAppealPaymentPortal = ConfigReader.getPropertiesFromConfigFile("Global","reasonOfAppealPaymentPortal");
	public static final String isOfficerField = ConfigReader.getPropertiesFromConfigFile("Global","isOfficerField");
	public static final String isServiceCharge = ConfigReader.getPropertiesFromConfigFile("Global","isServiceCharge");
	public static final String isLoginFrmPaymentPortal = ConfigReader.getPropertiesFromConfigFile("Global","isLoginPaymentPortal");
	
	public static final String canVioCode = ConfigReader.getPropertiesFromConfigFile("Global","isVioCode");
	public static final String canVioDesc = ConfigReader.getPropertiesFromConfigFile("Global","isVioDescription");
	public static final String canSuspend = ConfigReader.getPropertiesFromConfigFile("Global","isSuspend");
	public static final String canUnsuspend = ConfigReader.getPropertiesFromConfigFile("Global","isUnsuspend");
	public static final String canAppeal = ConfigReader.getPropertiesFromConfigFile("Global","isAppeal");
	public static final String canHearing = ConfigReader.getPropertiesFromConfigFile("Global","isHearing");
	public static final String canNote = ConfigReader.getPropertiesFromConfigFile("Global","isNote");
	public static final String canEdit = ConfigReader.getPropertiesFromConfigFile("Global","isEdit");
	public static final String canVoid = ConfigReader.getPropertiesFromConfigFile("Global","isVoid");
	public static final String canStatus = ConfigReader.getPropertiesFromConfigFile("Global","isStatus");
	public static final String maxAppealDays = ConfigReader.getPropertiesFromConfigFile("Global","maxAppelDays");
	public static final String maxHearingDays = ConfigReader.getPropertiesFromConfigFile("Global","maxHearingDays");
	public static final String lateCharge = ConfigReader.getPropertiesFromConfigFile("Global","lateFine");
	public static final String isBadgeID = ConfigReader.getPropertiesFromConfigFile("Global","isBadgeID");
	public static final String isSeperateBlock = ConfigReader.getPropertiesFromConfigFile("Global","seperateBlock");
	public static final String isSeperateSteet = ConfigReader.getPropertiesFromConfigFile("Global","seperateSteet");
	public static final String isPayFromAppeal = ConfigReader.getPropertiesFromConfigFile("Global","payFromAppeal");
	public static final String isPayFromHearing = ConfigReader.getPropertiesFromConfigFile("Global","payFromHearing");
	public static final String isPayFromFinancial = ConfigReader.getPropertiesFromConfigFile("Global","payFromFinancial");
	public static final String isPayFromPaymentPortal = ConfigReader.getPropertiesFromConfigFile("Global","payFromPaymentPro");
	public static final String isPayFromLinked = ConfigReader.getPropertiesFromConfigFile("Global","payFromLinked");
	public static final String isNSF = ConfigReader.getPropertiesFromConfigFile("Global","isNSF");
	public static final String isHearingEligibility = ConfigReader.getPropertiesFromConfigFile("Global","isHearingEligibility");
	public static final String isBillingAddressCheckbox = ConfigReader.getPropertiesFromConfigFile("Global","isBillingAddressCheckbox");
	
	public static final String appealState = ConfigReader.getPropertiesFromConfigFile("Global","appealState");
	public static final String appealReasonCategory = ConfigReader.getPropertiesFromConfigFile("Global","appealReasonCategory");
	
	public static final String processingProCardNumber = ConfigReader.getPropertiesFromConfigFile("Global","processingProCardNo");
	public static final String cardNumber = ConfigReader.getPropertiesFromConfigFile("Global","cardNumber");
	public static final String expiry = ConfigReader.getPropertiesFromConfigFile("Global","expiry");
	public static final String cvv = ConfigReader.getPropertiesFromConfigFile("Global","cvv");
	public static final String invalidCardNumber = ConfigReader.getPropertiesFromConfigFile("Global","invalidCardNumber");
	
	public static final String visaCardNumber = ConfigReader.getPropertiesFromConfigFile("Global","visaCard");
	public static final String mastercardCardNumber = ConfigReader.getPropertiesFromConfigFile("Global","masterCard");
	public static final String amexCardNumber = ConfigReader.getPropertiesFromConfigFile("Global","americanExpressCard");
	
	public static final String clientAdd1 = ConfigReader.getPropertiesFromConfigFile("Global","clientAdd1");
	public static final String clientAdd2 = ConfigReader.getPropertiesFromConfigFile("Global","clientAdd2");
	
	public static final String paymentProUrl = ConfigReader.getPropertiesFromConfigFile("Global","paymentProUrl");
	public static final String serviceCharge = ConfigReader.getPropertiesFromConfigFile("Global","serviceCharge");
	
	public static final String ipAddress = ConfigReader.getPropertiesFromConfigFile("Global","ipAddress");
	public static final String port = ConfigReader.getPropertiesFromConfigFile("Global","port");
	public static final String deviceName = ConfigReader.getPropertiesFromConfigFile("Global","deviceName");
	public static final String appUserName = ConfigReader.getPropertiesFromConfigFile("Global","appUserName");
	public static final String appPassword = ConfigReader.getPropertiesFromConfigFile("Global","appPassword");
	public static final String appPackage = ConfigReader.getPropertiesFromConfigFile("Global","applicationPackageName");
	public static final String appLot = ConfigReader.getPropertiesFromConfigFile("Global","appLot");
	public static final String appVioltion = ConfigReader.getPropertiesFromConfigFile("Global","appVioltion");
	public static final String appPrintedRemark = ConfigReader.getPropertiesFromConfigFile("Global","appPrintedRemark");
	public static final String appInternalNote = ConfigReader.getPropertiesFromConfigFile("Global","appInternalNote");
	public static final String appState = ConfigReader.getPropertiesFromConfigFile("Global","appState");
	public static final String runOnDevice = ConfigReader.getPropertiesFromConfigFile("Global","runOnDevice");
	
}
