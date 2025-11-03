package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.service.allocation_schemes.AllocationSchemeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class AllocationSchemeHelperDiffblueTest {
  @InjectMocks
  private AllocationSchemeHelper allocationSchemeHelper;

  @Mock
  private AllocationSchemeService allocationSchemeService;

  /**
   * Test {@link AllocationSchemeHelper#createAllocationScheme(String, long, String, String)}.
   * <p>
   * Method under test: {@link AllocationSchemeHelper#createAllocationScheme(String, long, String, String)}
   */
  @Test
  @DisplayName("Test createAllocationScheme(String, long, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AllocationSchemeHelper.createAllocationScheme(String, long, String, String)"})
  void testCreateAllocationScheme() {
    // Arrange
    when(allocationSchemeService.create(Mockito.<AllocationScheme>any())).thenReturn(1L);

    // Act
    long actualCreateAllocationSchemeResult = allocationSchemeHelper
        .createAllocationScheme("The characteristics of someone or something", 1L, "Name", "42");

    // Assert
    verify(allocationSchemeService).create(isA(AllocationScheme.class));
    assertEquals(1L, actualCreateAllocationSchemeResult);
  }
}
