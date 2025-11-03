package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableComponentRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComponentRowDiffblueTest {
  /**
   * Test Builder {@link Builder#category(String)}.
   * <p>
   * Method under test: {@link Builder#category(String)}
   */
  @Test
  @DisplayName("Test Builder category(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.category(String)"})
  void testBuilderCategory() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Test Builder {@link Builder#endDate(String)}.
   * <p>
   * Method under test: {@link Builder#endDate(String)}
   */
  @Test
  @DisplayName("Test Builder endDate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.endDate(String)"})
  void testBuilderEndDate() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endDate("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#from(ComponentRow)}.
   * <ul>
   *   <li>Then builder build version is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComponentRow)}
   */
  @Test
  @DisplayName("Test Builder from(ComponentRow); then builder build version is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComponentRow)"})
  void testBuilderFrom_thenBuilderBuildVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();
    ComponentRow instance = mock(ComponentRow.class);
    when(instance.reviewDate()).thenReturn("2020-03-01");
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.maintenanceStatus()).thenReturn(MaintenanceStatus.EXTENDED);
    when(instance.owner()).thenReturn("Owner");
    when(instance.category()).thenReturn("Category");
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.layer()).thenReturn("Layer");
    when(instance.tier()).thenReturn("Tier");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).layer();
    verify(instance).maintenanceStatus();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).reviewDate();
    verify(instance).tier();
    verify(instance).version();
    ImmutableComponentRow buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals("2020-03-01", buildResult.endDate());
    assertEquals("2020-03-01", buildResult.reviewDate());
    assertEquals("42", buildResult.internalId());
    assertEquals("Category", buildResult.category());
    assertEquals("Layer", buildResult.layer());
    assertEquals("Name", buildResult.name());
    assertEquals("Owner", buildResult.owner());
    assertEquals("Tier", buildResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, buildResult.maintenanceStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComponentRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ComponentRow)}
   */
  @Test
  @DisplayName("Test Builder from(ComponentRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ComponentRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();
    ComponentRow instance = mock(ComponentRow.class);
    when(instance.reviewDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.endDate()).thenReturn("2020-03-01");
    when(instance.maintenanceStatus()).thenReturn(MaintenanceStatus.EXTENDED);
    when(instance.owner()).thenReturn("Owner");
    when(instance.category()).thenReturn("Category");
    when(instance.version()).thenReturn("1.0.2");
    when(instance.name()).thenReturn("Name");
    when(instance.internalId()).thenReturn("42");
    when(instance.layer()).thenReturn("Layer");
    when(instance.tier()).thenReturn("Tier");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).endDate();
    verify(instance).internalId();
    verify(instance).layer();
    verify(instance).maintenanceStatus();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).reviewDate();
    verify(instance).tier();
    verify(instance).version();
  }

  /**
   * Test Builder {@link Builder#internalId(String)}.
   * <p>
   * Method under test: {@link Builder#internalId(String)}
   */
  @Test
  @DisplayName("Test Builder internalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.internalId(String)"})
  void testBuilderInternalId() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.internalId("42"));
  }

  /**
   * Test Builder {@link Builder#layer(String)}.
   * <p>
   * Method under test: {@link Builder#layer(String)}
   */
  @Test
  @DisplayName("Test Builder layer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.layer(String)"})
  void testBuilderLayer() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layer("Layer"));
  }

  /**
   * Test Builder {@link Builder#maintenanceStatus(MaintenanceStatus)}.
   * <p>
   * Method under test: {@link Builder#maintenanceStatus(MaintenanceStatus)}
   */
  @Test
  @DisplayName("Test Builder maintenanceStatus(MaintenanceStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.maintenanceStatus(MaintenanceStatus)"})
  void testBuilderMaintenanceStatus() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.maintenanceStatus(MaintenanceStatus.EXTENDED));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#owner(String)}.
   * <p>
   * Method under test: {@link Builder#owner(String)}
   */
  @Test
  @DisplayName("Test Builder owner(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.owner(String)"})
  void testBuilderOwner() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owner("Owner"));
  }

  /**
   * Test Builder {@link Builder#reviewDate(String)}.
   * <p>
   * Method under test: {@link Builder#reviewDate(String)}
   */
  @Test
  @DisplayName("Test Builder reviewDate(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.reviewDate(String)"})
  void testBuilderReviewDate() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.reviewDate("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#tier(String)}.
   * <p>
   * Method under test: {@link Builder#tier(String)}
   */
  @Test
  @DisplayName("Test Builder tier(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.tier(String)"})
  void testBuilderTier() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tier("Tier"));
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   * <p>
   * Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion() {
    // Arrange
    Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }
}
