package com.example.unittest.session5;

import com.example.unittest.session4.models.CollegeStudent;
import com.example.unittest.session4.models.StudentGrades;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private CollegeStudent collegeStudent;

    @Autowired
    private StudentGrades studentGrades;

    @Mock
    private ApplicationDao applicationDao;

    @InjectMocks
    private ApplicationService applicationService;


    @BeforeEach
    void setUp() {
        collegeStudent.setFirstname("Rosa");
        collegeStudent.setLastname("Sharifi");
        collegeStudent.setEmailAddress("rosa@gmail.com");
        collegeStudent.setStudentGrades(studentGrades);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void assertEqualsTestAddGrades() {
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);

        double v = applicationService.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults());

        assertEquals(100, v);

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }
}