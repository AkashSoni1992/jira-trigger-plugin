package com.ceilfors.jenkins.plugins.jirabuilder

import hudson.Extension
import hudson.model.AbstractProject
import hudson.model.BuildableItem
import hudson.model.Cause
import hudson.model.Item
import hudson.triggers.Trigger
import hudson.triggers.TriggerDescriptor
import org.kohsuke.stapler.DataBoundConstructor
import org.kohsuke.stapler.DataBoundSetter

/**
 * @author ceilfors
 */
class JiraBuilderTrigger extends Trigger<AbstractProject> {

    private String commentPattern

    @DataBoundConstructor
    JiraBuilderTrigger() {
        this.commentPattern = ""
    }

    String getCommentPattern() {
        return commentPattern
    }

    @DataBoundSetter
    void setCommentPattern(String commentPattern) {
        this.commentPattern = commentPattern
    }

    @Override
    DescriptorImpl getDescriptor() {
        return super.getDescriptor() as DescriptorImpl
    }

    @Extension
    static class DescriptorImpl extends TriggerDescriptor {

        public boolean isApplicable(Item item) {
            return item instanceof BuildableItem
        }

        public String getDisplayName() {
            return "JIRA Builder"
        }
    }

    static class JiraBuilderTriggerCause extends Cause {

        @Override
        String getShortDescription() {
            return "JIRA Builder"
        }
    }
}
