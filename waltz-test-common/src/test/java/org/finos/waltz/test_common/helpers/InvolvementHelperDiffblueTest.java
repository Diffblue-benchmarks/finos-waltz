package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class InvolvementHelperDiffblueTest {
  @InjectMocks
  private InvolvementHelper involvementHelper;

  @Mock
  private InvolvementService involvementService;

  @Mock
  private InvolvementKindService involvementKindService;

  /**
   * Test {@link InvolvementHelper#mkInvolvementKind(String)} with {@code name}.
   * <p>
   * Method under test: {@link InvolvementHelper#mkInvolvementKind(String)}
   */
  @Test
  @DisplayName("Test mkInvolvementKind(String) with 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long InvolvementHelper.mkInvolvementKind(String)"})
  void testMkInvolvementKindWithName() {
    // Arrange
    when(involvementKindService.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    long actualMkInvolvementKindResult = involvementHelper.mkInvolvementKind("Name");

    // Assert
    verify(involvementKindService).create(isA(InvolvementKindCreateCommand.class),
        eq("involvementHelper_c8e5b103-3229-49dc-b5a9-f0c8fd57fbf9"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Test {@link InvolvementHelper#mkInvolvementKind(String, String)} with {@code name}, {@code externalId}.
   * <p>
   * Method under test: {@link InvolvementHelper#mkInvolvementKind(String, String)}
   */
  @Test
  @DisplayName("Test mkInvolvementKind(String, String) with 'name', 'externalId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long InvolvementHelper.mkInvolvementKind(String, String)"})
  void testMkInvolvementKindWithNameExternalId() {
    // Arrange
    when(involvementKindService.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    long actualMkInvolvementKindResult = involvementHelper.mkInvolvementKind("Name", "42");

    // Assert
    verify(involvementKindService).create(isA(InvolvementKindCreateCommand.class),
        eq("involvementHelper_1a61be41-7e9d-42de-aafe-dc6284da1950"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Test {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}.
   * <p>
   * Method under test: {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}
   */
  @Test
  @DisplayName("Test createInvolvement(Long, long, EntityReference)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InvolvementHelper.createInvolvement(Long, long, EntityReference)"})
  void testCreateInvolvement() {
    // Arrange
    when(involvementService.addEntityInvolvement(Mockito.<String>any(), Mockito.<EntityReference>any(),
        Mockito.<EntityInvolvementChangeCommand>any())).thenReturn(true);

    // Act
    involvementHelper.createInvolvement(1L, 1L, null);

    // Assert
    verify(involvementService).addEntityInvolvement(eq("testuser_91a240e1-e3b9-44c8-8b18-2685bda4a221"), isNull(),
        isA(EntityInvolvementChangeCommand.class));
  }

  /**
   * Test {@link InvolvementHelper#markAsIntransitive(long)}.
   * <p>
   * Method under test: {@link InvolvementHelper#markAsIntransitive(long)}
   */
  @Test
  @DisplayName("Test markAsIntransitive(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InvolvementHelper.markAsIntransitive(long)"})
  void testMarkAsIntransitive() {
    // Arrange
    when(involvementKindService.update(Mockito.<InvolvementKindChangeCommand>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    involvementHelper.markAsIntransitive(1L);

    // Assert
    verify(involvementKindService).update(isA(InvolvementKindChangeCommand.class), eq("admin"));
  }
}
