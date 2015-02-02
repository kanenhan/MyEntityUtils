
import java.io.Serializable;
import java.util.Date;

/** sysuser
	ID	BIGINT(20)
	USERNAME	VARCHAR(50)
	PASSWORD	VARCHAR(50)
	TRUENAME	VARCHAR(50)
	SEX	VARCHAR(4)
	EMAIL	VARCHAR(50)
	TEL	VARCHAR(50)
	ASK	VARCHAR(50)
	ANSWER	VARCHAR(50)
	OTHER	VARCHAR(21845)
	MARK	VARCHAR(50)
	LOGINIP	VARCHAR(50)
	REGTIME	DATETIME(19)
	LOGINTIME	DATETIME(19)
	IDENTITYID	BIGINT(20)
	EXTENDF1	BIGINT(20)
	EXTENDF2	BIGINT(20)
	EXTENDF3	INTEGER(11)
	EXTENDF4	INTEGER(11)
	EXTENDF5	VARCHAR(255)
	EXTENDF6	VARCHAR(255)
	EXTENDF7	VARCHAR(255)
	EXTENDF8	VARCHAR(255)
	STATUS	INTEGER(11)
	ORDERBY	BIGINT(20)
	DEPT_ID	BIGINT(20)
	CODE	VARCHAR(50)
	FIRSTNAME	VARCHAR(50)
	LASTNAME	VARCHAR(50)
*/
public class Sysuser implements Serializable {
	private static final long serialVersionUID = 1L;
	private null id;
	private String username;
	private String password;
	private String truename;
	private String sex;
	private String email;
	private String tel;
	private String ask;
	private String answer;
	private String other;
	private String mark;
	private String loginip;
	private Date regtime;
	private Date logintime;
	private null identityid;
	private null extendf1;
	private null extendf2;
	private Integer extendf3;
	private Integer extendf4;
	private String extendf5;
	private String extendf6;
	private String extendf7;
	private String extendf8;
	private Integer status;
	private null orderby;
	private null deptId;
	private String code;
	private String firstname;
	private String lastname;

	public void setId(null id){
		this.id=id;
	}
	public null getId(){
		return id;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setTruename(String truename){
		this.truename=truename;
	}
	public String getTruename(){
		return truename;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public String getTel(){
		return tel;
	}
	public void setAsk(String ask){
		this.ask=ask;
	}
	public String getAsk(){
		return ask;
	}
	public void setAnswer(String answer){
		this.answer=answer;
	}
	public String getAnswer(){
		return answer;
	}
	public void setOther(String other){
		this.other=other;
	}
	public String getOther(){
		return other;
	}
	public void setMark(String mark){
		this.mark=mark;
	}
	public String getMark(){
		return mark;
	}
	public void setLoginip(String loginip){
		this.loginip=loginip;
	}
	public String getLoginip(){
		return loginip;
	}
	public void setRegtime(Date regtime){
		this.regtime=regtime;
	}
	public Date getRegtime(){
		return regtime;
	}
	public void setLogintime(Date logintime){
		this.logintime=logintime;
	}
	public Date getLogintime(){
		return logintime;
	}
	public void setIdentityid(null identityid){
		this.identityid=identityid;
	}
	public null getIdentityid(){
		return identityid;
	}
	public void setExtendf1(null extendf1){
		this.extendf1=extendf1;
	}
	public null getExtendf1(){
		return extendf1;
	}
	public void setExtendf2(null extendf2){
		this.extendf2=extendf2;
	}
	public null getExtendf2(){
		return extendf2;
	}
	public void setExtendf3(Integer extendf3){
		this.extendf3=extendf3;
	}
	public Integer getExtendf3(){
		return extendf3;
	}
	public void setExtendf4(Integer extendf4){
		this.extendf4=extendf4;
	}
	public Integer getExtendf4(){
		return extendf4;
	}
	public void setExtendf5(String extendf5){
		this.extendf5=extendf5;
	}
	public String getExtendf5(){
		return extendf5;
	}
	public void setExtendf6(String extendf6){
		this.extendf6=extendf6;
	}
	public String getExtendf6(){
		return extendf6;
	}
	public void setExtendf7(String extendf7){
		this.extendf7=extendf7;
	}
	public String getExtendf7(){
		return extendf7;
	}
	public void setExtendf8(String extendf8){
		this.extendf8=extendf8;
	}
	public String getExtendf8(){
		return extendf8;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setOrderby(null orderby){
		this.orderby=orderby;
	}
	public null getOrderby(){
		return orderby;
	}
	public void setDeptId(null deptId){
		this.deptId=deptId;
	}
	public null getDeptId(){
		return deptId;
	}
	public void setCode(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setFirstname(String firstname){
		this.firstname=firstname;
	}
	public String getFirstname(){
		return firstname;
	}
	public void setLastname(String lastname){
		this.lastname=lastname;
	}
	public String getLastname(){
		return lastname;
	}
}

