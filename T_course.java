
import java.io.Serializable;

/** t_course
	ID	BIGINT(20)
	NAME	VARCHAR(21845)
	TYPE	INTEGER(11)
	CODE	VARCHAR(5592405)
	TOTALPERIODNUM	INTEGER(11)
	PRACPERIODNUM	INTEGER(11)
	TEAMETHOD	INTEGER(11)
	SCORE	INTEGER(11)
	PRACDESC	VARCHAR(715827882)
	COMPULSORY	TINYINT(1)
	ENGNAME	VARCHAR(21845)
	APPLYPERID	BIGINT(20)
	APPLYPERUNITID	BIGINT(20)
	COUNATUREID	BIGINT(20)
	ASSMETHODID	BIGINT(20)
	COUVERSION	INTEGER(11)
	COUBIGTYPEID	BIGINT(20)
	COUATTRIBUTEID	BIGINT(20)
	WEEKTIME	INTEGER(11)
	THEORYTIME	INTEGER(11)
	PRACTICETIME	INTEGER(11)
	EXPTIME	INTEGER(11)
	CPUTIME	INTEGER(11)
	COUSEUINITID	VARCHAR(21845)
	COUSEDESC	VARCHAR(715827882)
	COUREASON	VARCHAR(715827882)
*/
public class T_course implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Integer type;
	private String code;
	private Integer totalperiodnum;
	private Integer pracperiodnum;
	private Integer teamethod;
	private Integer score;
	private String pracdesc;
	private Integer compulsory;
	private String engname;
	private Long applyperid;
	private Long applyperunitid;
	private Long counatureid;
	private Long assmethodid;
	private Integer couversion;
	private Long coubigtypeid;
	private Long couattributeid;
	private Integer weektime;
	private Integer theorytime;
	private Integer practicetime;
	private Integer exptime;
	private Integer cputime;
	private String couseuinitid;
	private String cousedesc;
	private String coureason;

	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setType(Integer type){
		this.type=type;
	}
	public Integer getType(){
		return type;
	}
	public void setCode(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setTotalperiodnum(Integer totalperiodnum){
		this.totalperiodnum=totalperiodnum;
	}
	public Integer getTotalperiodnum(){
		return totalperiodnum;
	}
	public void setPracperiodnum(Integer pracperiodnum){
		this.pracperiodnum=pracperiodnum;
	}
	public Integer getPracperiodnum(){
		return pracperiodnum;
	}
	public void setTeamethod(Integer teamethod){
		this.teamethod=teamethod;
	}
	public Integer getTeamethod(){
		return teamethod;
	}
	public void setScore(Integer score){
		this.score=score;
	}
	public Integer getScore(){
		return score;
	}
	public void setPracdesc(String pracdesc){
		this.pracdesc=pracdesc;
	}
	public String getPracdesc(){
		return pracdesc;
	}
	public void setCompulsory(Integer compulsory){
		this.compulsory=compulsory;
	}
	public Integer getCompulsory(){
		return compulsory;
	}
	public void setEngname(String engname){
		this.engname=engname;
	}
	public String getEngname(){
		return engname;
	}
	public void setApplyperid(Long applyperid){
		this.applyperid=applyperid;
	}
	public Long getApplyperid(){
		return applyperid;
	}
	public void setApplyperunitid(Long applyperunitid){
		this.applyperunitid=applyperunitid;
	}
	public Long getApplyperunitid(){
		return applyperunitid;
	}
	public void setCounatureid(Long counatureid){
		this.counatureid=counatureid;
	}
	public Long getCounatureid(){
		return counatureid;
	}
	public void setAssmethodid(Long assmethodid){
		this.assmethodid=assmethodid;
	}
	public Long getAssmethodid(){
		return assmethodid;
	}
	public void setCouversion(Integer couversion){
		this.couversion=couversion;
	}
	public Integer getCouversion(){
		return couversion;
	}
	public void setCoubigtypeid(Long coubigtypeid){
		this.coubigtypeid=coubigtypeid;
	}
	public Long getCoubigtypeid(){
		return coubigtypeid;
	}
	public void setCouattributeid(Long couattributeid){
		this.couattributeid=couattributeid;
	}
	public Long getCouattributeid(){
		return couattributeid;
	}
	public void setWeektime(Integer weektime){
		this.weektime=weektime;
	}
	public Integer getWeektime(){
		return weektime;
	}
	public void setTheorytime(Integer theorytime){
		this.theorytime=theorytime;
	}
	public Integer getTheorytime(){
		return theorytime;
	}
	public void setPracticetime(Integer practicetime){
		this.practicetime=practicetime;
	}
	public Integer getPracticetime(){
		return practicetime;
	}
	public void setExptime(Integer exptime){
		this.exptime=exptime;
	}
	public Integer getExptime(){
		return exptime;
	}
	public void setCputime(Integer cputime){
		this.cputime=cputime;
	}
	public Integer getCputime(){
		return cputime;
	}
	public void setCouseuinitid(String couseuinitid){
		this.couseuinitid=couseuinitid;
	}
	public String getCouseuinitid(){
		return couseuinitid;
	}
	public void setCousedesc(String cousedesc){
		this.cousedesc=cousedesc;
	}
	public String getCousedesc(){
		return cousedesc;
	}
	public void setCoureason(String coureason){
		this.coureason=coureason;
	}
	public String getCoureason(){
		return coureason;
	}
}

