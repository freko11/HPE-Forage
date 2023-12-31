package com.example.forage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.forage.Model.Employee;
import com.example.forage.Model.EmployeeManager;
import com.example.forage.Model.Employees;
import com.example.forage.controller.EmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        // Setup
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1, "John", "Doe", "john.doe@email.com", "Developer"));
        when(employeeManager.getEmployees()).thenReturn(new Employees(mockEmployees));

        // Test
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeList[0].first_name").value("John"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        // Setup
        Employee newEmployee = new Employee(2, "Jane", "Smith", "jane.smith@email.com", "Designer");
        when(employeeManager.getEmployees()).thenReturn(new Employees(new ArrayList<>()));

        // Test
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .content(asJsonString(newEmployee))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeList[0].first_name").value("Jane"));
    }

    // Utility method to convert objects to JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
