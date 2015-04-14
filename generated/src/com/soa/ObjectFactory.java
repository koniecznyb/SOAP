
package com.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStudentListResponse_QNAME = new QName("http://soa.com/", "getStudentListResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://soa.com/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://soa.com/", "hello");
    private final static QName _GetStudentResponse_QNAME = new QName("http://soa.com/", "getStudentResponse");
    private final static QName _GetStudent_QNAME = new QName("http://soa.com/", "getStudent");
    private final static QName _GetStudentList_QNAME = new QName("http://soa.com/", "getStudentList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link GetStudentListResponse }
     * 
     */
    public GetStudentListResponse createGetStudentListResponse() {
        return new GetStudentListResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetStudentList }
     * 
     */
    public GetStudentList createGetStudentList() {
        return new GetStudentList();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link Student.Subjects }
     * 
     */
    public Student.Subjects createStudentSubjects() {
        return new Student.Subjects();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.com/", name = "getStudentListResponse")
    public JAXBElement<GetStudentListResponse> createGetStudentListResponse(GetStudentListResponse value) {
        return new JAXBElement<GetStudentListResponse>(_GetStudentListResponse_QNAME, GetStudentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.com/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.com/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.com/", name = "getStudentList")
    public JAXBElement<GetStudentList> createGetStudentList(GetStudentList value) {
        return new JAXBElement<GetStudentList>(_GetStudentList_QNAME, GetStudentList.class, null, value);
    }

}
