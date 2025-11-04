package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.service.allocation_schemes.AllocationSchemeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class AllocationSchemeHelperDiffblueTest {
  /**
   * Method under test:
   * {@link AllocationSchemeHelper#createAllocationScheme(String, long, String, String)}
   */
  @Test
  void testCreateAllocationScheme() {
    // Arrange
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.create(Mockito.<AllocationScheme>any())).thenReturn(1L);
    AllocationSchemeHelper allocationSchemeHelper = new AllocationSchemeHelper();
    ReflectionTestUtils.setField(allocationSchemeHelper, "allocationSchemeService", allocationSchemeService);

    // Act
    long actualCreateAllocationSchemeResult = allocationSchemeHelper
        .createAllocationScheme("The characteristics of someone or something", 1L, "Name", "42");

    // Assert
    verify(allocationSchemeService).create(isA(AllocationScheme.class));
    assertEquals(1L, actualCreateAllocationSchemeResult);
  }
}
