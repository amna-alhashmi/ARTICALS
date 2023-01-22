
public class Docs {
	
	String	section_name;
	String subsection_name;
	Byline byline;
	String _id;
	
	
	public Byline getByline() {
		return byline;
	}
	public void setByline(Byline byline) {
		this.byline = byline;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public String getSubsection_name() {
		return subsection_name;
	}
	public void setSubsection_name(String subsection_name) {
		this.subsection_name = subsection_name;
	}
	
}
