package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecificationDeleteCommand;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class PhysicalSpecHelperDiffblueTest {
  @InjectMocks
  private PhysicalSpecHelper physicalSpecHelper;

  @Mock
  private PhysicalSpecificationService physicalSpecificationService;

  /**
   * Test {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}
   */
  @Test
  @DisplayName("Test createPhysicalSpec(EntityReference, String); then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long PhysicalSpecHelper.createPhysicalSpec(EntityReference, String)"})
  void testCreatePhysicalSpec_thenReturnLongValueIsOne() {
    // Arrange
    when(physicalSpecificationService.create(Mockito.<ImmutablePhysicalSpecification>any())).thenReturn(1L);

    // Act
    Long actualCreatePhysicalSpecResult = physicalSpecHelper.createPhysicalSpec(mock(EntityReference.class), "Name");

    // Assert
    verify(physicalSpecificationService).create(isA(ImmutablePhysicalSpecification.class));
    assertEquals(1L, actualCreatePhysicalSpecResult.longValue());
  }

  /**
   * Test {@link PhysicalSpecHelper#removeSpec(Long)}.
   * <p>
   * Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  @DisplayName("Test removeSpec(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PhysicalSpecHelper.removeSpec(Long)"})
  void testRemoveSpec() {
    // Arrange
    when(physicalSpecificationService.markRemovedIfUnused(Mockito.<PhysicalSpecificationDeleteCommand>any(),
        Mockito.<String>any())).thenReturn(null);

    // Act
    physicalSpecHelper.removeSpec(1L);

    // Assert
    verify(physicalSpecificationService).markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class),
        eq("deletingSpec_4f2cb07a-1e7c-4325-9050-5aea98ccbd3e"));
  }
}
