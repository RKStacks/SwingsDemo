
import java.math.BigDecimal;

/** ****************************************************************************
* Project :Shree Garments Salary Module
* Developed By: techmomentous.com
* Visit: www.techmomentous.com
* Developer: Rizwan Ahmad Khan
* *****************************************************************************/
public class Operations {
	//Database field
	Long		id;
	String		operationName;
	String		operationCode;
	BigDecimal	rate10;
	BigDecimal	rate11;
	BigDecimal	rate12;
	BigDecimal	rate1;
	BigDecimal	rate2;
	BigDecimal	rate3;
	BigDecimal	rate4;
	String		total;
	public Operations(Long id, String operationName, String operationCode, BigDecimal rate10, BigDecimal rate11,
			BigDecimal rate12, BigDecimal rate1, BigDecimal rate2, BigDecimal rate3, String total, Long employeeID,
			String employeeName) {
		super();
		this.id = id;
		this.operationName = operationName;
		this.operationCode = operationCode;
		this.rate10 = rate10;
		this.rate11 = rate11;
		this.rate12 = rate12;
		this.rate1 = rate1;
		this.rate2 = rate2;
		this.rate3 = rate3;
		this.total = total;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}

	//Table Model Field
	Long		employeeID;
	String		employeeName;
	//Custom Field
	boolean		isUpdate	= false;

	public Operations() {
	}

	/**Constructor For Operations Combo Box
	 * @param id
	 * @param operationName
	 * @param operationCode
	 * @param rate
	 */
	public Operations(Long id, String operationName, String operationCode, BigDecimal rate) {
		super();
		this.id = id;
		this.operationName = operationName;
		this.operationCode = operationCode;
		this.rate10 = rate;
	}

	/**Constructor For Empty Operations Combo Box
	 * @param id
	 * @param operationName
	 * @param operationCode
	 * @param rate10
	 */
	public Operations(String operationName, String operationCode) {
		super();
		this.operationName = operationName;
		this.operationCode = operationCode;
	}

	/**Constructor For Rate Combo Box
	 * @param id
	 * @param operationName
	 * @param operationCode
	 * @param rate
	 */
	public Operations(Long id, BigDecimal rate) {
		super();
		this.id = id;
		this.rate10 = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public BigDecimal getRate() {
		return rate10;
	}

	public BigDecimal getRate10() {
		return rate10;
	}

	public void setRate10(BigDecimal rate10) {
		this.rate10 = rate10;
	}

	public BigDecimal getRate11() {
		return rate11;
	}

	public void setRate11(BigDecimal rate11) {
		this.rate11 = rate11;
	}

	public BigDecimal getRate12() {
		return rate12;
	}

	public void setRate12(BigDecimal rate12) {
		this.rate12 = rate12;
	}

	public BigDecimal getRate1() {
		return rate1;
	}

	public void setRate1(BigDecimal rate1) {
		this.rate1 = rate1;
	}

	public BigDecimal getRate2() {
		return rate2;
	}

	public void setRate2(BigDecimal rate2) {
		this.rate2 = rate2;
	}

	public BigDecimal getRate3() {
		return rate3;
	}

	public void setRate3(BigDecimal rate3) {
		this.rate3 = rate3;
	}

	public BigDecimal getRate4() {
		return rate4;
	}

	public void setRate4(BigDecimal rate4) {
		this.rate4 = rate4;
	}

	public void setRate(BigDecimal rate) {
		this.rate10 = rate;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Operations [id=" + id + ", operationName=" + operationName + ", operationCode=" + operationCode
				+ ", rate=" + rate10 + "]";
	}

	public void setIsupdated(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public Boolean isUpdated() {
		return isUpdate;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
