package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableComponentRowDiffblueTest {
  /**
   * Method under test: {@link ImmutableComponentRow.Builder#category(String)}
   */
  @Test
  void testBuilderCategory() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#endDate(String)}
   */
  @Test
  void testBuilderEndDate() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endDate("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#from(ComponentRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();
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
    ImmutableComponentRow.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableComponentRow.Builder#from(ComponentRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();
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
   * Method under test: {@link ImmutableComponentRow.Builder#internalId(String)}
   */
  @Test
  void testBuilderInternalId() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.internalId("42"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#layer(String)}
   */
  @Test
  void testBuilderLayer() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layer("Layer"));
  }

  /**
   * Method under test:
   * {@link ImmutableComponentRow.Builder#maintenanceStatus(MaintenanceStatus)}
   */
  @Test
  void testBuilderMaintenanceStatus() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.maintenanceStatus(MaintenanceStatus.EXTENDED));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#owner(String)}
   */
  @Test
  void testBuilderOwner() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owner("Owner"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#reviewDate(String)}
   */
  @Test
  void testBuilderReviewDate() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.reviewDate("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#tier(String)}
   */
  @Test
  void testBuilderTier() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tier("Tier"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow.Builder#version(String)}
   */
  @Test
  void testBuilderVersion() {
    // Arrange
    ImmutableComponentRow.Builder builderResult = ImmutableComponentRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Method under test: {@link ImmutableComponentRow#copyOf(ComponentRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableComponentRow actualCopyOfResult = ImmutableComponentRow.copyOf(instance);

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
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("2020-03-01", actualCopyOfResult.endDate());
    assertEquals("2020-03-01", actualCopyOfResult.reviewDate());
    assertEquals("42", actualCopyOfResult.internalId());
    assertEquals("Category", actualCopyOfResult.category());
    assertEquals("Layer", actualCopyOfResult.layer());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owner", actualCopyOfResult.owner());
    assertEquals("Tier", actualCopyOfResult.tier());
    assertEquals(MaintenanceStatus.EXTENDED, actualCopyOfResult.maintenanceStatus());
  }
}
